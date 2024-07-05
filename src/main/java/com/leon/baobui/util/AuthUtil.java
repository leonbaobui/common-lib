package main.java.com.leon.baobui.util;

import main.java.com.leon.baobui.exception.ApiRequestException;
import main.java.com.leon.baobui.constants.ErrorMessage;
import main.java.com.leon.baobui.constants.PathConstants;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

public class AuthUtil {

    public static Long getAuthenticatedUserId() {
        RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) attribs).getRequest();
        String userId = request.getHeader(PathConstants.AUTH_USER_ID_HEADER);

        if (userId == null) {
            throw new ApiRequestException(ErrorMessage.USER_NOT_FOUND, HttpStatus.NOT_FOUND);
        } else {
            return Long.parseLong(userId);
        }
    }

    public static Long getAuthenticatedUserId(HttpServletRequest request) {
        String userId = request.getHeader(PathConstants.AUTH_USER_ID_HEADER);

        if (userId == null) {
            throw new ApiRequestException(ErrorMessage.USER_NOT_FOUND, HttpStatus.NOT_FOUND);
        } else {
            return Long.parseLong(userId);
        }
    }
}
