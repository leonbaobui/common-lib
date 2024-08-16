package main.java.com.leon.baobui.configuration;

import feign.RequestInterceptor;
import main.java.com.leon.baobui.constants.PathConstants;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@ConditionalOnProperty(
        name = "infrastructure.services.feign.request-interceptor.enabled",
        havingValue = "true"
)
public class FeignConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = ((ServletRequestAttributes) attributes).getRequest();
            template.header(PathConstants.AUTH_USER_ID_HEADER, request.getHeader(PathConstants.AUTH_USER_ID_HEADER));
        };
    }
}
