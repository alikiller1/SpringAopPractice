package org.kingszelda.version1.service;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by shining.cui on 2017/7/15.
 */
@Component
public class MethodCounter {

    private static final Logger logger = LoggerFactory.getLogger(MethodCounter.class);

    //防止并发
    private static final Map<String, Integer> methodCountMap = Maps.newConcurrentMap();

    /**
     * 根据方法名进行调用次数计数
     */
    public void count(String methodName) {
        Integer methodCount = methodCountMap.get(methodName);
        if (methodCount == null) {
            methodCount = 1;
        } else {
            methodCount++;
        }
        logger.info("对方法{}进行次数加1，当前次数为:{}", methodName, methodCount);
        methodCountMap.put(methodName, methodCount);
    }

    public Map<String, Integer> getMethodCountMap() {
        return methodCountMap;
    }
}
