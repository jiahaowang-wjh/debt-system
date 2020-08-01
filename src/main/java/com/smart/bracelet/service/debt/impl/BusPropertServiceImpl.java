package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusPropertDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusPropert;
import com.smart.bracelet.model.vo.debt.BusPropertVo;
import com.smart.bracelet.service.debt.BusPropertService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BusPropertServiceImpl implements BusPropertService {

    @Autowired
    private BusPropertDao busPropertDao;

    @Override
    public int deleteByPrimaryKey(Long propertId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busPropertDao.deleteByPrimaryKey(propertId);
            log.info("删除资产信息成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除资产信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除资产信息失败");
        }
    }

    @Override
    public int insertSelective(BusPropert record) throws CustomerException {
        try {
            record.setPropertId(IdUtils.nextId());
            int insertSelective = busPropertDao.insertSelective(record);
            log.info("新增资产信息成功,受影响行数:{}",insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增资产信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增资产信息失败");
        }
    }

    @Override
    public BusPropert selectByPrimaryKey(Long propertId) {
        return busPropertDao.selectByPrimaryKey(propertId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusPropertVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = busPropertDao.updateByPrimaryKeySelective(record);
            log.info("更新资产信息成功,受影响行数:{}",updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新资产信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新资产信息失败");
        }
    }

    @Override
    public List<BusPropert> queryList() {
        return busPropertDao.queryList();
    }
}
