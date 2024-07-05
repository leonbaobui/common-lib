package main.java.com.leon.baobui.dto.response.user;

import lombok.Data;

@Data
public class UserPrincipalResponse {
    private Long id;
    private String email;
    private Boolean active;
}
