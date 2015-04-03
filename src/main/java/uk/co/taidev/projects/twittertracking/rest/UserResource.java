package uk.co.taidev.projects.twittertracking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.co.taidev.projects.twittertracking.models.User;
import uk.co.taidev.projects.twittertracking.repository.UserRepository;
import uk.co.taidev.projects.twittertracking.rest.model.UserView;
import uk.co.taidev.projects.twittertracking.services.UserService;
import uk.co.taidev.projects.twittertracking.spring.OrikaMapping;

import java.util.UUID;

@RestController
@RequestMapping("/api/twittertracking/v1/users")
public class UserResource {

    private final OrikaMapping orikaMapping;
    private final UserService userService;


    @Autowired
    public UserResource(OrikaMapping orikaMapping, UserService userService) {
        this.orikaMapping = orikaMapping;
        this.userService = userService;
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserView getUser(@PathVariable String userId) {
        User user = userService.getUser(UUID.fromString(userId));
        return orikaMapping.map(user, UserView.class);
    }
}
