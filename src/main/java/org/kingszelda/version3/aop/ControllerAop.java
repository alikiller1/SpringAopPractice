package org.kingszelda.version3.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 基于AspectJ的切面功能
 *
 * @author shining.cui
 * @since 2017-07-16
 */
@Aspect
@Component
public class ControllerAop extends MethodCounter {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAop.class);

    // 拦截version3包中的所有service
    @Pointcut("(execution(* org.kingszelda.version3.service.*.*(..)))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object controllerHandler(ProceedingJoinPoint joinPoint) {
        String signature = joinPoint.getSignature().toShortString();
        //1.统计调用次数
        count(signature);
        String argStr = Arrays.toString(joinPoint.getArgs());
        //2.打印请求
        logger.info("方法{}的请求参数为{}", signature, argStr);
        Object result = null;
        //3.获得计算开始时间
        long start = System.currentTimeMillis();
        try {
            //4.运行业务
            result = joinPoint.proceed();
        } catch (Throwable e) {
            logger.error("web 应用发生异常", e);
        }
        //5.打印运行时间
        logger.info("方法{}运行时间:{}ms", signature, System.currentTimeMillis() - start);
        String returnValue = String.valueOf(result);
        //6.打印响应
        logger.info("方法{}的响应结果为{}", signature, returnValue);
        return result;
    }

}
