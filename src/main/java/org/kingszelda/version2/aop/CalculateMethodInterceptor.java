package org.kingszelda.version2.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.kingszelda.version2.service.CalculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.IntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * 方法后切面，打印响应结果
 * Created by shining.cui on 2017/7/15.
 */
@Component
public class CalculateMethodInterceptor implements IntroductionInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(CalculateMethodInterceptor.class);

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //1.获得计算开始时间
        long start = System.currentTimeMillis();
        String methodName = methodInvocation.getMethod().getDeclaringClass().getSimpleName() + "." + methodInvocation.getMethod().getName();
        //2.运行程序
        Object proceed = methodInvocation.proceed();
        //3.打印间隔时间
        logger.info("方法{}运行时间:{}ms", methodName, System.currentTimeMillis() - start);
        return proceed;
    }

    public boolean implementsInterface(Class<?> aClass) {
        //满足CalculateService接口的方法都进行拦截
        return aClass.isAssignableFrom(CalculateService.class);
    }
}
