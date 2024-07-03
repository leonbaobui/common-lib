package com.twitter.lib.dto.response.notification;

import lombok.Data;

@Data
public class NotificationTweetResponse {
    private Long id;
    private String text;
    private Long authorId;
    private boolean notificationCondition;
}
