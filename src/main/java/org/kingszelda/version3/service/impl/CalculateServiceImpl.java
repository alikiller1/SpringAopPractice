package org.kingszelda.version3.service.impl;

import org.kingszelda.common.dao.AddDao;
import org.kingszelda.common.dao.SubDao;
import org.kingszelda.version3.service.CalculateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by shining.cui on 2017/7/15.
 */
@Service("calculateServiceV3")
public class CalculateServiceImpl implements CalculateService {

    @Resource
    private AddDao addDao;

    @Resource
    private SubDao subDao;

    public int add(int first, int second) {
        //1.计算加法
        int result = first + second;
        //2.插入数据库
        addDao.insert(first, second, result);
        //3.返回结果
        return result;
    }

    public int sub(int first, int second) {
        //1.计算加法
        int result = first - second;
        //2.插入数据库
        subDao.insert(first, second, result);
        //3.返回结果
        return result;
    }
}
