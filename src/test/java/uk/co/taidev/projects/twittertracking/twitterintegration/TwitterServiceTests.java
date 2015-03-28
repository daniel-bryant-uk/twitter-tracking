package uk.co.taidev.projects.twittertracking.twitterintegration;

import org.junit.Test;
import twitter4j.TwitterFactory;
import uk.co.taidev.projects.twittertracking.services.TwitterService;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class TwitterServiceTests {

    private TwitterService twitterService = new TwitterService(TwitterFactory.getSingleton());

    @Test
    public void validSearchReturnsResults() throws Exception {
        List<String> tweetResults = twitterService.search("microservices");

        assertThat(tweetResults, hasSize(greaterThan(1)));
    }
}
