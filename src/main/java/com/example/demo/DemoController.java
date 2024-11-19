package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

@RestController
public class DemoController implements ErrorController {
    
    @GetMapping("/")
    public String helloWorld() {
        return "Hello ";
    }

    // Write the login api with parameter username and password and in header token key

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestParam("user") String user, @RequestParam("pass") String pass, @RequestHeader("validToken") String token) {
        Map<String, String> response = new HashMap<>();
        if (user.equals("testUser") && pass.equals("testPass") && token.equals("testToken")) {
            response.put("message", "Login successful");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Login failed");
            return ResponseEntity.badRequest().body(response);
        }
    }   
    
    // Write api for registration with parameter username. password, mobilenumber and in header token key
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestParam("user") String user, @RequestParam("pass") String pass, @RequestParam("mobile") String mobile, @RequestHeader("validToken") String token) {
        Map<String, String> response = new HashMap<>();
        if (token.equals("testToken")) {
            // Here you would typically save the user details to a database
            response.put("message", "Registration successful");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Registration failed");
            return ResponseEntity.badRequest().body(response);
        }
    }



}
