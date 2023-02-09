package test.local;

/*
import com.pab.framework.foundation.Foundation;
import com.pab.framework.redis.lock.RedisLock;
import com.pab.framework.redis.lock.RedisLockFactoryBean;
import com.pab.kycrapp.constant.TopicConstant;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@Order(99)
public class UniqueAspect {

    @Autowired
    RedisLockFactoryBean RedisLockFactoryBean;

    @Value("${spring.mqs.cid:default}")
    private String cid;

    @Pointcut("execution(* com.pab.kycrapp.mq.consumer.*.onMessage(..))")
    public void pointCut() {
        //sonar 扫描：空的方法体，如果确定不会执行的，要抛异常规范一下，或者注释为啥这里不会执行
        throw new UnsupportedOperationException();
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        StringBuilder builder = new StringBuilder("Lock");
        for (int i = 0; i < args.length - 1; i++) {
            try {
                if ("java.lang.String".equals(args[i].getClass().getTypeName())) {
                    builder.append(args[i]);
                }
            } catch (NullPointerException ex) {
                //不应该出现null
            }
        }
        String lockKey = builder.toString() + cid;
        log.info("UniqueAspect 处理{}", lockKey);
        RedisLock redisLock = RedisLockFactoryBean.getLock(lockKey);
        Object proceed = null;
        */
/**
         * 如果没获取到锁，直接返回，不进行后续处理了
         * 也就不会走到后面逻辑，进而释放不属于自己的锁
         *//*

        if (!redisLock.tryLock2()) {
            log.error("UniqueAspect 没有获取到锁{}", lockKey);
            return proceed;
        } else {
            log.info("UniqueAspect 获取到锁，正确执行 {}", lockKey);
        }
        */
/**
         * 锁一加一放，成对出现，切记
         * 否则主动重试就获取不到锁了
         *//*

        try {
            return pjp.proceed();
        } finally {
            log.info("UniqueAspect 释放锁{}", lockKey);
            try {
                redisLock.unlock();
            } catch (Exception e) {
                log.info("解锁异常", e);
            }
        }
    }
}
*/
