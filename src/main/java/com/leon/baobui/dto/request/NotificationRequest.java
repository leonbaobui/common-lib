package main.java.com.leon.baobui.dto.request;

import main.java.com.leon.baobui.dto.response.tweet.TweetResponse;
import main.java.com.leon.baobui.enums.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
    private NotificationType notificationType;
    private Long notifiedUserId;
    private Long userId;
    private Long userToFollowId;
    private Long tweetId;
    private Long listId;
    private boolean notificationCondition;
    private TweetResponse tweet;
}
