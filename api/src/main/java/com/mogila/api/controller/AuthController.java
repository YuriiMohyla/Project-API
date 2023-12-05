package com.mogila.api.controller;

import com.mogila.api.dto.LoginDto;
import com.mogila.api.utils.SecurityContextUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final SecurityContextRepository contextRepository;

    // $2a$10$US6vxyHWnvLFwGBHIuNZ7.9dmWABzD5nVQ6jLcZBNijdHpedbn1Gq
    @PostMapping("/api/login")
    public void login(@RequestBody LoginDto loginDto, HttpServletRequest request, HttpServletResponse response) {
        final UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(loginDto.getLogin(), loginDto.getPassword());
        final Authentication authenticated = authenticationManager.authenticate(token);

        contextRepository.saveContext(SecurityContextUtils.forAuthentication(authenticated), request, response);
    }
}
