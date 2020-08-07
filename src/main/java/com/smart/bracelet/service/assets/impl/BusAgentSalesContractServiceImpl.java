package com.smart.bracelet.service.assets.impl;

import com.smart.bracelet.dao.assets.BusAgentSalesContractDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAgentSalesContract;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractVo;
import com.smart.bracelet.service.assets.BusAgentSalesContractService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BusAgentSalesContractServiceImpl implements BusAgentSalesContractService {

    @Autowired
    private BusAgentSalesContractDao busAgentSalesContractDao;

    @Override
    public int deleteByPrimaryKey(Long salesContractId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busAgentSalesContractDao.deleteByPrimaryKey(salesContractId);
            log.info("删除资产委托代理销售合同成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除资产委托代理销售合同失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除资产委托代理销售合同失败");
        }
    }

    @Override
    public int insertSelective(BusAgentSalesContract record) throws CustomerException {
        try {
            record.setSalesContractId(IdUtils.nextId());
            int deleteByPrimaryKey = busAgentSalesContractDao.insertSelective(record);
            log.info("新增资产委托代理销售合同成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("新增资产委托代理销售合同失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增资产委托代理销售合同失败");
        }
    }

    @Override
    public BusAgentSalesContract selectByPrimaryKey(Long salesContractId) {
        return busAgentSalesContractDao.selectByPrimaryKey(salesContractId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusAgentSalesContractVo record) throws CustomerException {
        try {
            int deleteByPrimaryKey = busAgentSalesContractDao.updateByPrimaryKeySelective(record);
            log.info("更新资产委托代理销售合同成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("更新资产委托代理销售合同失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新资产委托代理销售合同失败");
        }
    }

    @Override
    public List<BusAgentSalesContract> queryList() {
        return busAgentSalesContractDao.queryList();
    }
}
