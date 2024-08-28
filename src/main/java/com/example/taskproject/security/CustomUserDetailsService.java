package com.example.taskproject.security;
import java.util.Optional;
import com.example.taskproject.entity.Users;
import com.example.taskproject.exception.UserNotFound;
import com.example.taskproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFound(String.format("User with email: %s is not found", email)));

        // Create and return UserDetails object
        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())// Add roles or authorities as needed
                .build();
    }
}
