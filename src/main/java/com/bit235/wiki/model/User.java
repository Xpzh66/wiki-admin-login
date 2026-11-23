/*
 * Name: Guanzhang He
 * Student ID: S1580804
 * BIT235 Assessment 2 - Part A: Wiki Administrator Login and User Authentication
 */
package com.bit235.wiki.model;

/**
 * Model class representing a wiki administrator account.
 * It acts as the form-backing object: the browser form fields
 * "username" and "password" are bound to these two properties.
 */
public class User {

    // Username submitted from the login form
    private String username;

    // Password submitted from the login form
    private String password;

    // No-argument constructor required by Spring form binding
    public User() {
    }

    // Convenience constructor used by the repository to hold the accepted account
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter and setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
