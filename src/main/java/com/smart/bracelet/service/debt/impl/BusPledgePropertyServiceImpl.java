package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusPledgePropertyDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusPledgeProperty;
import com.smart.bracelet.model.vo.debt.BusPledgePropertyVo;
import com.smart.bracelet.service.debt.BusPledgePropertyService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BusPledgePropertyServiceImpl implements BusPledgePropertyService {

    @Autowired
    private BusPledgePropertyDao busPledgePropertyDao;

    @Override
    public int deleteByPrimaryKey(Long pledgePropertyId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busPledgePropertyDao.deleteByPrimaryKey(pledgePropertyId);
            log.info("删除质押财产信息成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除质押财产信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("删除质押财产信息失败");
        }
    }

    @Override
    public int insertSelective(BusPledgeProperty record) throws CustomerException {
        try {
            record.setPledgePropertyId(IdUtils.nextId());
            int insertSelective = busPledgePropertyDao.insertSelective(record);
            log.info("新增质押财产信息成功,受影响行数:{}",insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增质押财产信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增质押财产信息失败");
        }
    }

    @Override
    public BusPledgeProperty selectByPrimaryKey(Long pledgePropertyId) {
        return busPledgePropertyDao.selectByPrimaryKey(pledgePropertyId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusPledgePropertyVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = busPledgePropertyDao.updateByPrimaryKeySelective(record);
            log.info("更新质押财产信息成功,受影响行数:{}",updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新质押财产信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("更新质押财产信息失败");
        }
    }

    @Override
    public List<BusPledgeProperty> queryList() {
        return busPledgePropertyDao.queryList();
    }
}
