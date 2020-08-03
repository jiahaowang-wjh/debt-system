package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusPledgeContractDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusPledgeContract;
import com.smart.bracelet.model.vo.debt.BusPledgeContractVo;
import com.smart.bracelet.service.debt.BusPledgeContractService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BusPledgeContractServiceImpl implements BusPledgeContractService {

    @Autowired
    private BusPledgeContractDao busPledgeContractDao;

    @Override
    public int deleteByPrimaryKey(Long pledgeContractId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busPledgeContractDao.deleteByPrimaryKey(pledgeContractId);
            log.info("删除质押合同成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除质押合同失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除质押合同失败");
        }
    }

    @Override
    public int insertSelective(BusPledgeContract record) throws CustomerException {
        try {
            record.setPledgeContractId(IdUtils.nextId());
            int insertSelective = busPledgeContractDao.insertSelective(record);
            log.info("新增质押合同成功,受影响行数:{}", insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增质押合同失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增质押合同失败");
        }
    }

    @Override
    public BusPledgeContract selectByPrimaryKey(Long pledgeContractId) {
        return busPledgeContractDao.selectByPrimaryKey(pledgeContractId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusPledgeContractVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = busPledgeContractDao.updateByPrimaryKeySelective(record);
            log.info("更新质押合同成功,受影响行数:{}", updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新质押合同失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新质押合同失败");
        }
    }

    @Override
    public List<BusPledgeContract> queryList() {
        return busPledgeContractDao.queryList();
    }
}
