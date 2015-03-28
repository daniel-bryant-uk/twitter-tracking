package uk.co.taidev.projects.twittertracking.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.*;
import uk.co.taidev.projects.twittertracking.exceptions.ExternalServiceUnavailableException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TwitterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterService.class);


    private Twitter twitter;


    @Autowired
    public TwitterService(Twitter twitter) {
        this.twitter = twitter;
    }


    public List<String> search(String searchTerms) {
        QueryResult queryResult = getQueryResult(searchTerms);

        return queryResult.getTweets().stream()
                .map(t -> t.getCreatedAt() + t.getUser().getScreenName() + t.getText())
                .collect(Collectors.toList());
    }

    private QueryResult getQueryResult(String searchTerms) {
        QueryResult queryResult;

        try {
            queryResult = twitter.search(new Query(searchTerms));
        } catch (TwitterException te) {
            throw new ExternalServiceUnavailableException(te);
        }

        logRateLimitInfo(queryResult.getRateLimitStatus());

        return queryResult;
    }


    private void logRateLimitInfo(RateLimitStatus rateLimitStatus) {
        LOGGER.debug(String.format("Twitter rate limit remaining %s out of %s.",
                rateLimitStatus.getRemaining(),
                rateLimitStatus.getLimit()));
        LOGGER.debug(String.format("Time until reset %d",
                rateLimitStatus.getSecondsUntilReset()));
    }
}
