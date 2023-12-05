package com.mogila.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class LoginDto {
    @NonNull
    private String login;
    @NonNull
    private String password;
}
