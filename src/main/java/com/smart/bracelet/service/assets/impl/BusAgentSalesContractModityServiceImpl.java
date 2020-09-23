package com.smart.bracelet.service.assets.impl;

import com.smart.bracelet.dao.assets.BusAgentSalesContractModityDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAgentSalesContractModity;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractModityVo;
import com.smart.bracelet.service.assets.BusAgentSalesContractModityService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class BusAgentSalesContractModityServiceImpl implements BusAgentSalesContractModityService {

    @Autowired
    private BusAgentSalesContractModityDao busAgentSalesContractModityDao;

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long salesContractModityId) throws CustomerException {
        try {
            return busAgentSalesContractModityDao.deleteByPrimaryKey(salesContractModityId);
        } catch (Exception e) {
            log.error("删除失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public Long insertSelective(BusAgentSalesContractModity record) throws CustomerException {
        try {
            long l = IdUtils.nextId();
            record.setSalesContractModityId(l);
            return l;
        } catch (Exception e) {
            log.error("新增失败.异常信息:{}", e.getMessage());
            throw new CustomerException("新增失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public BusAgentSalesContractModity selectByPrimaryKey(Long salesContractModityId) {
        return busAgentSalesContractModityDao.selectByPrimaryKey(salesContractModityId);
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(BusAgentSalesContractModityVo record) throws CustomerException {
        try {
            return busAgentSalesContractModityDao.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            log.error("更新失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新失败");
        }
    }

    @Override
    public List<BusAgentSalesContractModity> selectBySalesContractId(Long salesContractId) {
        List<BusAgentSalesContractModity> list = busAgentSalesContractModityDao.selectBySalesContractId(salesContractId);
        return list;
    }
}
