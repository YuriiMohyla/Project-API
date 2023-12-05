package com.mogila.api.service;

import com.mogila.api.dto.ProductionDto;
import com.mogila.api.model.User;
import com.mogila.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DatabaseUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return findUserByLogin(username);
    }

    public ProductionDto findUserProduction(@NonNull String username) {
        return userRepository.findByLogin(username)
                .map(User::getProduction)
                .map(ProductionDto::of)
                .orElseThrow(() -> handleNotFound(username));
    }

    public User findUserByLogin(@NonNull String username) {
        return userRepository.findByLogin(username)
                .orElseThrow(() -> handleNotFound(username));
    }

    private static UsernameNotFoundException handleNotFound(String username) {
        return new UsernameNotFoundException(String.format("Failed to find user with login: '%s", username));
    }
}
