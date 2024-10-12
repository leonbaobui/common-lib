package main.java.com.leon.baobui.resilience4j.annotation;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Resilience4jCustom {

  boolean enableCircuitBreaker() default true;
  boolean enableRetry() default true;
  boolean enableBulkhead() default true;
  boolean enableTimeLimiter() default true;

  @AliasFor(annotation = CircuitBreaker.class, attribute = "name")
  String circuitBreakerName() default "defaultCircuitBreaker";

  @AliasFor(annotation = Retry.class, attribute = "name")
  String retryName() default "defaultRetry";

  @AliasFor(annotation = Bulkhead.class, attribute = "name")
  String bulkheadName() default "defaultBulkhead";

  @AliasFor(annotation = TimeLimiter.class, attribute = "name")
  String timeLimiterName() default "defaultTimeLimiter";

  String fallbackMethod() default "fallback";
}
