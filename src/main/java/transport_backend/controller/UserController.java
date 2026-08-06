package transport_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import transport_backend.dto.LoginRequest;
import transport_backend.dto.LoginResponse;
import transport_backend.entity.User;
import transport_backend.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return service.login(request);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

}