package com.bni.taskmgtapp.controller;


import org.springframework.web.bind.annotation.*;
import com.bni.taskmgtapp.util.JwtUtil;


@RestController
public class AuthController {

    private final JwtUtil jwtService;

    public AuthController(JwtUtil jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/get-token/{username}")
    public String getToken(@PathVariable String username) {
        return jwtService.createToken(username);
    }


    @PostMapping("/validate-token")
    public String validateToken(@RequestBody String token) {
        try {
            return "Token is valid" + jwtService.validateToken(token);
        }catch (Exception e) {
            return "Token is invalid" + e.getMessage();
        }
    }


}
