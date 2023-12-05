package com.mogila.api.controller;

import com.mogila.api.dto.ProductionDto;
import com.mogila.api.service.DatabaseUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/production")
@AllArgsConstructor
public class UserController {
    private final DatabaseUserDetailsService userDetailsService;


    @GetMapping
    public ProductionDto getProductionDto(Principal user) {
        return userDetailsService.findUserProduction(user.getName());
    }
}
