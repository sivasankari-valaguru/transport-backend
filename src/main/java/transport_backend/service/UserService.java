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

        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid Password");
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