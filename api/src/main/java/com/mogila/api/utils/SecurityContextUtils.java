package com.mogila.api.utils;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;

@UtilityClass
public class SecurityContextUtils {
    public SecurityContext forAuthentication(@NonNull Authentication authentication) {
        final SecurityContextHolderStrategy strategy = SecurityContextHolder.getContextHolderStrategy();
        final SecurityContext context = strategy.createEmptyContext();

        context.setAuthentication(authentication);
        strategy.setContext(context);

        return context;
    }
}
