package com.mogila.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

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
    private Integer verificationPeriod;
    @NonNull
    private String note;
    @NonNull
    private List<VerificationDto> verifications;
    @NonNull
    private List<RepairDto> repairs;

    public LocalDate getLastVerification() {
        return verifications.stream()
                .max(Comparator.comparing(VerificationDto::getDateOfVerification))
                .map(VerificationDto::getDateOfVerification)
                .map(localDate -> localDate.plusMonths(verificationPeriod))
                .get();
    }
}
