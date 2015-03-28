package uk.co.taidev.projects.twittertracking.twitterintegration;

import org.junit.Test;
import twitter4j.*;

public class TwitterServiceTests {

    @Test
    public void authenticationSucceedsWithValidLogin() throws Exception {
        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query("microservices");
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }
    }
}
