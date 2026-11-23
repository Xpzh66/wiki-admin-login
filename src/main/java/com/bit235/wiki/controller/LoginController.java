/*
 * Name: Guanzhang He
 * Student ID: S1580804
 * BIT235 Assessment 2 - Part A: Wiki Administrator Login and User Authentication
 */
package com.bit235.wiki.controller;

import com.bit235.wiki.model.User;
import com.bit235.wiki.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller layer: handles HTTP requests for the login flow.
 * It receives form data, calls the service for validation,
 * and selects which View (Thymeleaf template) to return.
 */
@Controller
public class LoginController {

    // Service used to verify the submitted credentials
    private final LoginService loginService;

    // Constructor injection: Spring injects the login service bean
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * GET request: show the empty login form.
     * Maps both "/" and "/login" so the home page opens the login screen.
     */
    @GetMapping({"/", "/login"})
    public String showLoginPage(Model model) {
        // Add an empty User object so the form can bind to its fields
        model.addAttribute("user", new User());
        // Return the "login" Thymeleaf template (templates/login.html)
        return "login";
    }

    /**
     * POST request: receive the submitted form and authenticate.
     * @ModelAttribute binds the submitted username/password onto a User object
     */
    @PostMapping("/login")
    public String handleLogin(@ModelAttribute("user") User user, Model model) {

        // Delegate the actual check to the service layer
        boolean authenticated = loginService.authenticate(user.getUsername(), user.getPassword());

        if (authenticated) {
            // Success: pass a welcome message to the welcome page
            model.addAttribute("message", "Welcome, " + user.getUsername().trim() + "!");
            return "welcome";
        }

        // Failure: pass an error message to the error page
        model.addAttribute("error", "Invalid username or password. Please try again.");
        return "error";
    }
}
