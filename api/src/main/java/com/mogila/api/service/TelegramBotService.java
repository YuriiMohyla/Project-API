package com.mogila.api.service;

import com.mogila.api.client.TelegramBotClient;
import com.mogila.api.dto.UserNotificationDto;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class TelegramBotService {
    private static final String MESSAGE = "Прилад '%s' потребує повірки '%s'";

    private final TelegramBotClient botClient;

    public void publishNotification(@NonNull Map<String, LocalDate> lastVerifications, @NonNull Long userId) {
        botClient.publishNotification(buildNotifications(lastVerifications, userId));
    }

    private UserNotificationDto buildNotifications(Map<String, LocalDate> lastVerifications, Long userId) {
        List<String> messages = lastVerifications.entrySet().stream()
                .map(entry -> MESSAGE.formatted(entry.getKey(), DateTimeFormatter.ISO_DATE.format(entry.getValue())))
                .toList();

        return UserNotificationDto.builder()
                .userId(userId)
                .messages(messages)
                .build();
    }
}
