package com.mogila.api.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
public class UserNotificationDto {
    @NonNull
    private Long userId;
    @NonNull
    private List<Notification> messages;

    @Data
    @AllArgsConstructor(staticName = "of")
    public static class Notification {
        @NonNull
        private String message;
        @NonNull
        private ZonedDateTime date;
    }
}
