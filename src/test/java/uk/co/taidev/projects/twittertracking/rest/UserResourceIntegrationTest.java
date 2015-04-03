package uk.co.taidev.projects.twittertracking.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import uk.co.taidev.projects.twittertracking.Application;
import uk.co.taidev.projects.twittertracking.models.User;
import uk.co.taidev.projects.twittertracking.repository.UserRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles({"dev"})
@IntegrationTest("server.port=0")
public class UserResourceIntegrationTest {

    @Autowired
    private UserResource subject;

    @Autowired
    private UserRepository userRepository;

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(subject).build();
    }

    @Test
    public void retrieveExistingUser() throws Exception {
        User user = userRepository.save(new User("John", "Doe"));

        assertThat(user.getId(), is(notNullValue()));

        mvc.perform(MockMvcRequestBuilders.get("/api/twittertracking/v1/users/{userId}", user.getId().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName", is("John")))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}
