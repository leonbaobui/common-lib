package main.java.com.leon.baobui.resilience4j.aop;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.ThreadPoolBulkhead;
import io.github.resilience4j.bulkhead.ThreadPoolBulkheadRegistry;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.core.functions.CheckedSupplier;
import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import lombok.RequiredArgsConstructor;
import main.java.com.leon.baobui.resilience4j.annotation.Resilience4jCustom;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import

@Aspect
@Component
@RequiredArgsConstructor
public class ResilienceAspect {
  private final CircuitBreakerRegistry circuitBreakerRegistry;
  private final RetryRegistry retryRegistry;
  private final RateLimiterRegistry rateLimiterRegistry;
  private final ThreadPoolBulkheadRegistry threadPoolBulkheadRegistry;

  @Around("@annotation(resilience4jCustom)")
  public Object applyResilience(ProceedingJoinPoint joinPoint, Resilience4jCustom resilience4jCustom) throws Throwable {
    CheckedSupplier<Object> supplier = joinPoint::proceed;
    Decorators.DecorateCheckedSupplier<Object> decoratedSupplier = Decorators.ofCheckedSupplier(supplier);


    if (resilience4jCustom.enableCircuitBreaker()) {
      CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker(resilience4jCustom.circuitBreakerName());
      decoratedSupplier.withCircuitBreaker(circuitBreaker);
    }

    if (resilience4jCustom.enableRetry()) {
      Retry retry = retryRegistry.retry(resilience4jCustom.retryName());
      decoratedSupplier.withRetry(retry);
    }

    if (resilience4jCustom.enableRateLimiter()) {
      RateLimiter rateLimiter = rateLimiterRegistry.rateLimiter(resilience4jCustom.rateLimiterName());
      decoratedSupplier.withRateLimiter(rateLimiter);
    }

//    if (resilience4jCustom.enableBulkhead()) {
//      ThreadPoolBulkhead bulkhead = threadPoolBulkheadRegistry.bulkhead(resilience4jCustom.bulkheadName());
//      supplier = ThreadPoolBulkhead.decorateSupplier(bulkhead, supplier);
//    }

    return decoratedSupplier.get();
  }
}
