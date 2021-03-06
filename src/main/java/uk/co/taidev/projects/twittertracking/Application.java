package uk.co.taidev.projects.twittertracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Twitter getTwitter() {
        return TwitterFactory.getSingleton();
    }
}
