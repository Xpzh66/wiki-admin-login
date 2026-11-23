/*
 * Name: Guanzhang He
 * Student ID: S1580804
 * BIT235 Assessment 2 - Part A: Wiki Administrator Login and User Authentication
 */
package com.bit235.wiki.service;

import com.bit235.wiki.model.User;
import com.bit235.wiki.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Service layer: holds the business logic for authentication.
 * The controller delegates the credential check here, so the validation
 * rule stays separate from web request handling.
 */
@Service
public class LoginService {

    // Repository that provides the accepted account
    private final UserRepository userRepository;

    // Constructor injection: Spring injects the repository bean
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Checks whether the submitted username and password match the
     * hard-coded accepted account stored in the repository.
     * @param username name entered on the login form
     * @param password password entered on the login form
     * @return true when both credentials match, false otherwise
     */
    public boolean authenticate(String username, String password) {
        User accepted = userRepository.findAcceptedUser();

        // Remove accidental leading/trailing spaces before comparing
        String submittedUsername = username == null ? "" : username.trim();
        String submittedPassword = password == null ? "" : password.trim();

        // Both fields must equal the accepted credentials
        return accepted.getUsername().equals(submittedUsername)
                && accepted.getPassword().equals(submittedPassword);
    }
}
