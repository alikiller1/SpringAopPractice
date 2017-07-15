package org.kingszelda.version2.aop;

import org.kingszelda.version2.service.MethodCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 方法前切面，打印请求参数，统计调用次数
 * Created by shining.cui on 2017/7/15.
 */
@Component
public class CalculateBeforeAdvice extends MethodCounter implements MethodBeforeAdvice {

    private static final Logger logger = LoggerFactory.getLogger(CalculateBeforeAdvice.class);

    public void before(Method method, Object[] args, Object target) throws Throwable {
        String methodName = method.getDeclaringClass().getSimpleName() + "." + method.getName();
        String argStr = Arrays.toString(args);
        logger.info("方法{}的请求参数为{}", methodName, argStr);
        count(methodName);
    }
}
