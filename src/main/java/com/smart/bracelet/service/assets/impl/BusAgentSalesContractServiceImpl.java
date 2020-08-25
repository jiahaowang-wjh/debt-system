package com.smart.bracelet.service.assets.impl;

import com.smart.bracelet.dao.assets.BusAgentSalesContractDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAgentSalesContract;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractVo;
import com.smart.bracelet.service.assets.BusAgentSalesContractService;
import com.smart.bracelet.utils.IdUtils;
import com.smart.bracelet.utils.RepNoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusAgentSalesContractServiceImpl implements BusAgentSalesContractService {

    @Autowired
    private BusAgentSalesContractDao busAgentSalesContractDao;

    @Override
    public int deleteByPrimaryKey(Long salesContractId) throws CustomerException {
        try {
            int i = busAgentSalesContractDao.deleteByPrimaryKey(salesContractId);
            return i;
        } catch (Exception e) {
            log.error("删除失败,异常信息:{}",e.getMessage());
            throw new CustomerException("删除失败");
        }
    }

    @Override
    public int insertSelective(BusAgentSalesContract record) throws CustomerException {
        try {
            String a = busAgentSalesContractDao.selectNo();
            record.setSalesContractId(IdUtils.nextId());
            record.setSalesNo(RepNoUtils.createRepNo("TZ","DLXS",a));
            return busAgentSalesContractDao.insertSelective(record);
        } catch (Exception e) {
            log.error("新增失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增失败");
        }
    }

    @Override
    public BusAgentSalesContract selectByPrimaryKey(Long salesContractId) {
        return busAgentSalesContractDao.selectByPrimaryKey(salesContractId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusAgentSalesContractVo record) throws CustomerException {
        try {
            return busAgentSalesContractDao.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            log.error("更新失败,异常信息:{}",e.getMessage());
            throw new CustomerException("更新失败");
        }
    }
}
