package com.mogila.api.controller;

import com.mogila.api.dto.ProductionDto;
import com.mogila.api.dto.UserDto;
import com.mogila.api.service.DatabaseUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class UserController {
    private final DatabaseUserDetailsService userDetailsService;

    @GetMapping("/production")
    public ProductionDto getProductionDto(Principal user) {
        return userDetailsService.findUserProduction(user.getName());
    }

    @GetMapping("/user")
    public UserDto getUserInfo(Principal user) {
        return userDetailsService.findUserById(user.getName());
    }
}
