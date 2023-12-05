package com.mogila.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class DeviceDto {
    @NonNull
    private String title;
    @NonNull
    private String typeBrand;
    @NonNull
    private String registryNumber;
    @NonNull
    private String inventoryNumber;
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfLastVerification;
    @NonNull
    private Integer verificationPeriod;
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfLastRepair;
    @NonNull
    private String note;
}
