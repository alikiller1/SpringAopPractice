package org.kingszelda.version3.aop;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by shining.cui on 2017/7/15.
 */
@Service("methodCounterV3")
public class MethodCounter {

    private static final Logger logger = LoggerFactory.getLogger(MethodCounter.class);

    //key-方法名，value-调用次数
    private static final Map<String, Integer> methodCountMap = Maps.newConcurrentMap();

    //所有调用次数，不论什么方法名
    private AtomicInteger allCount = new AtomicInteger();

    /**
     * CalculateBeforeAdvice的调用入口
     */
    protected void count(Method method) {
        count(method.getName());
    }

    /**
     * 根据方法名统计调用次数
     */
    protected void count(String methodName) {
        Integer methodCount = methodCountMap.get(methodName);
        methodCount = (methodCount != null) ? new Integer(methodCount + 1) : new Integer(1);
        logger.info("对方法{}进行次数加1，当前次数为:{}", methodName, methodCount);
        methodCountMap.put(methodName, methodCount);
        allCount.getAndIncrement();
    }

    /**
     * 根据方法名获取调用次数
     */
    public int getCalls(String methodName) {
        Integer count = methodCountMap.get(methodName);
        return count != null ? count : 0;
    }

    /**
     * 获取所有调用次数
     */
    public int getAllCalls() {
        return allCount.get();
    }

    /**
     * 获取调用次数详情
     */
    public Map<String, Integer> getCountMap() {
        return methodCountMap;
    }


}
