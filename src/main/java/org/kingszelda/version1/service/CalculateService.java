package org.kingszelda.version1.service;

import org.kingszelda.common.dao.AddDao;
import org.kingszelda.common.dao.SubDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by shining.cui on 2017/7/15.
 */
@Service
public class CalculateService {

    private static final Logger logger = LoggerFactory.getLogger(CalculateService.class);

    @Resource
    private AddDao addDao;

    @Resource
    private SubDao subDao;

    @Resource
    private MethodCounter methodCounter;

    public int add(int first, int second) {
        //1.打印入口参数
        logger.info("add 方法入参为:{}{}", first, second);
        //2.计算调用次数
        methodCounter.count("add");
        logger.info("开始计算加法,first={},second={}", first, second);
        //3.计算加法
        int result = first + second;
        //4.插入数据库
        addDao.insert(first, second, result);
        //5.打印返回参数
        logger.info("add 方法结果为:{}", result);
        //6.返回结果
        return result;
    }

    public int sub(int first, int second) {
        //1.打印入口参数
        logger.info("sub 方法入参为:{}{}", first, second);
        //2.计算调用次数
        methodCounter.count("sub");
        logger.info("开始计算减法，first={},second={}", first, second);
        //3.计算加法
        int result = first - second;
        //4.插入数据库
        subDao.insert(first, second, result);
        //5.打印返回参数
        logger.info("sub 方法结果为:{}", result);
        //6.返回结果
        return result;
    }
}
