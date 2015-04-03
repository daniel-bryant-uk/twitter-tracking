package uk.co.taidev.projects.twittertracking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.taidev.projects.twittertracking.models.User;
import uk.co.taidev.projects.twittertracking.repository.UserRepository;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User getUser(UUID userId) {
        return userRepository.findOne(userId);
    }
}
