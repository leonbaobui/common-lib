package main.java.com.leon.baobui.util;

import main.java.com.leon.baobui.constants.PathConstants;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class TestUtil {
    public static void mockAuthenticatedUserId() {
        MockHttpServletRequest mockRequest = new MockHttpServletRequest();
        mockRequest.addHeader(PathConstants.AUTH_USER_ID_HEADER, TestConstants.USER_ID);
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(mockRequest));
    }
}
