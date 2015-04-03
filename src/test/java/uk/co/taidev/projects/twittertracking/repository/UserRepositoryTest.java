package uk.co.taidev.projects.twittertracking.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.co.taidev.projects.twittertracking.Application;
import uk.co.taidev.projects.twittertracking.models.User;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ActiveProfiles({"dev"})
public class UserRepositoryTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryTest.class);


    @Autowired
    private UserRepository subject;


    @Test
    public void validUserPersists() {
        User user = new User("John", "Doe");

        subject.save(user);

        assertThat(user.getId(), is(notNullValue()));
        LOGGER.info("User saved {}", user);
    }

}
