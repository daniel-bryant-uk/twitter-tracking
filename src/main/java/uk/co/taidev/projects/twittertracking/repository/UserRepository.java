package uk.co.taidev.projects.twittertracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.taidev.projects.twittertracking.models.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
