package org.kingszelda.version2.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * 方法后切面，打印响应结果
 * Created by shining.cui on 2017/7/15.
 */
@Resource
public class CalculateAfterAdvice implements AfterReturningAdvice {

    private static final Logger logger = LoggerFactory.getLogger(CalculateAfterAdvice.class);

    public void afterReturning(Object returnObject, Method method, Object[] args, Object target) throws Throwable {
        String methodName = method.getName();
        String returnValue = String.valueOf(returnObject);
        logger.info("方法{}的响应结果为{}", methodName, returnValue);
    }
}
