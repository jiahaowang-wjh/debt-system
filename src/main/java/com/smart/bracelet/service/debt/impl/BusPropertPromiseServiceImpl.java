package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusPropertPromiseDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusPropertPromise;
import com.smart.bracelet.model.vo.debt.BusPropertPromiseVo;
import com.smart.bracelet.service.debt.BusPropertPromiseService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BusPropertPromiseServiceImpl implements BusPropertPromiseService {

    @Autowired
    private BusPropertPromiseDao busPropertPromiseDao;

    @Override
    public int deleteByPrimaryKey(Long promiseId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busPropertPromiseDao.deleteByPrimaryKey(promiseId);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除资产承诺书失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除资产承诺书失败");
        }
    }

    @Override
    public int insertSelective(BusPropertPromise record) throws CustomerException {
        try {
            record.setPromiseId(IdUtils.nextId());
            int insertSelective = busPropertPromiseDao.insertSelective(record);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增资产承诺书失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增资产承诺书失败");
        }
    }

    @Override
    public BusPropertPromise selectByPrimaryKey(Long promiseId) throws CustomerException {
        BusPropertPromise busPropertPromise = busPropertPromiseDao.selectByPrimaryKey(promiseId);
        return busPropertPromise;
    }

    @Override
    public int updateByPrimaryKeySelective(BusPropertPromiseVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = busPropertPromiseDao.updateByPrimaryKeySelective(record);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新资产承诺书失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新资产承诺书失败");
        }
    }

    @Override
    public List<BusPropertPromise> queryList() {
        return busPropertPromiseDao.queryList();
    }
}
