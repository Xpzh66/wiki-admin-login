/*
 * Name: Guanzhang He
 * Student ID: S1580804
 * BIT235 Assessment 2 - Part A: Wiki Administrator Login and User Authentication
 */
package com.bit235.wiki.repository;

import com.bit235.wiki.model.User;
import org.springframework.stereotype.Repository;

/**
 * Repository layer.
 * In this first stage there is no database, so the single acceptable
 * administrator account is hard-coded here. A later stage can replace
 * this class with a JPA repository without changing the service layer.
 */
@Repository
public class UserRepository {

    // Hard-coded acceptable account: lower-case first name and fixed password "123"
    private static final User ACCEPTED_USER = new User("heguanzhang", "123");

    /**
     * Returns the single administrator account allowed to log in.
     * @return the hard-coded accepted User
     */
    public User findAcceptedUser() {
        return ACCEPTED_USER;
    }
}
