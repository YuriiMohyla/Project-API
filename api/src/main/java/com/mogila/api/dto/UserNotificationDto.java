package com.mogila.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
public class UserNotificationDto {
    @NonNull
    private Long userId;
    @NonNull
    private List<String> messages;
}
