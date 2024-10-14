package main.java.com.leon.baobui.resilience4j.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Resilience4jCustom {

  boolean enableCircuitBreaker() default true;
  String circuitBreakerName() default "defaultCircuitBreaker";

  boolean enableRetry() default true;
  String retryName() default "defaultRetry";

  boolean enableRateLimiter() default false;
  String rateLimiterName() default "defaultRateLimiter";

  boolean enableBulkhead() default false;
  String bulkheadName() default "defaultThreadPoolBulkhead";
}
