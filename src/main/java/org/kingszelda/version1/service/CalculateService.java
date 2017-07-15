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
        //1.获得计算开始时间
        long start = System.currentTimeMillis();
        //2.打印入口参数
        logger.info("方法入参为:{}{}", first, second);
        //3.计算调用次数
        methodCounter.count("sub");
        //4.计算加法
        int result = first + second;
        //5.插入数据库
        addDao.insert(first, second, result);
        //6.打印返回参数
        logger.info("方法结果为:{}", result);
        //7.打印方法总耗时
        logger.info("运行时间:{}ms", System.currentTimeMillis() - start);
        //8.返回结果
        return result;
    }

    public int sub(int first, int second) {
        //1.获得计算开始时间
        long start = System.currentTimeMillis();
        //2.打印入口参数
        logger.info("方法入参为:{}{}", first, second);
        //3.计算调用次数
        methodCounter.count("sub");
        //4.计算加法
        int result = first - second;
        //5.插入数据库
        subDao.insert(first, second, result);
        //6.打印返回参数
        logger.info("sub 方法结果为:{}", result);
        //7.打印方法总耗时
        logger.info("运行时间:{}ms", System.currentTimeMillis() - start);
        //8.返回结果
        return result;
    }
}
