package com.mogila.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class RepairDto {
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfRepair;
    @NonNull
    private String characteristic;
}
