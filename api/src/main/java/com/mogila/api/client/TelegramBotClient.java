package com.mogila.api.client;

import com.mogila.api.dto.UserNotificationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "telegram-bot-client", url = "${telegram.bot.url}")
public interface TelegramBotClient {
    @PostMapping("/notification")
    void publishNotification(@RequestBody UserNotificationDto notificationDto);
}
