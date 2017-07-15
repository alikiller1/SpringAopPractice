package org.kingszelda.version2.service.impl;

import org.kingszelda.common.dao.AddDao;
import org.kingszelda.common.dao.SubDao;
import org.kingszelda.version2.service.CalculateService;

import javax.annotation.Resource;

/**
 * Created by shining.cui on 2017/7/15.
 */
public class CalculateServiceImpl implements CalculateService {

    @Resource
    private AddDao addDao;

    @Resource
    private SubDao subDao;

    @Override
    public int add(int first, int second) {
        //1.计算加法
        int result = first + second;
        //2.插入数据库
        addDao.insert(first, second, result);
        //3.返回结果
        return result;
    }

    @Override
    public int sub(int first, int second) {
        //1.计算加法
        int result = first - second;
        //2.插入数据库
        subDao.insert(first, second, result);
        //3.返回结果
        return result;
    }
}
