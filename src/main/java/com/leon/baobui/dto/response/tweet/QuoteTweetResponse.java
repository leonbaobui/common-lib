package main.java.com.leon.baobui.dto.response.tweet;

import com.fasterxml.jackson.annotation.JsonProperty;
import main.java.com.leon.baobui.enums.LinkCoverSize;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class QuoteTweetResponse {
    private Long id;
    private String text;
    private LocalDateTime dateTime;
    private String link;
    private String linkTitle;
    private String linkDescription;
    private String linkCover;
    private LinkCoverSize linkCoverSize;
    private TweetAuthorResponse user;
    @JsonProperty("isDeleted")
    private boolean isDeleted;
}
