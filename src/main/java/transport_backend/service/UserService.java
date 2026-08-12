package transport_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transport_backend.dto.LoginRequest;
import transport_backend.dto.LoginResponse;
import transport_backend.entity.User;
import transport_backend.repository.UserRepository;
import transport_backend.security.JwtService;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private JwtService jwtService;

    public LoginResponse login(LoginRequest request) {

        System.out.println("LOGIN REQUEST");
        System.out.println("Username/Email: " + request.getEmail());

        User user = repository.findByEmail(request.getEmail().trim())
                .orElseGet(() ->
                    repository.findByUsername(request.getEmail().trim())
                        .orElseThrow(() ->
                            new RuntimeException(
                                "User not found: " + request.getEmail()
                            )
                        )
                );

        System.out.println("USER FOUND: " + user.getUsername());
        System.out.println("ROLE: " + user.getRole());

        if (user.getPassword() == null) {
            throw new RuntimeException("Password is NULL in database");
        }

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(
                "Login Successful",
                user.getRole(),
                token
        );
    }

    public User register(User user) {
        user.setId(null);
        return repository.save(user);
    }
}