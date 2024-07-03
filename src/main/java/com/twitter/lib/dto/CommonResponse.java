package com.twitter.lib.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class CommonResponse {
    private String httpStatus;
    private String message;
}
