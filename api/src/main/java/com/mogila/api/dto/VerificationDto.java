package com.mogila.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class VerificationDto {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfVerification;
    @NonNull
    private String verificationPlace;
    @NonNull
    private String typeOfVerification;
    @NonNull
    private String conclusion;
}
