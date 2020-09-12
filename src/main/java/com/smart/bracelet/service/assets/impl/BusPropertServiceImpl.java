package com.smart.bracelet.service.assets.impl;

import com.smart.bracelet.dao.assets.BusPropertDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusPropert;
import com.smart.bracelet.model.vo.assets.AssetsDebtBank;
import com.smart.bracelet.model.vo.assets.AssetsMyDebt;
import com.smart.bracelet.model.vo.debt.BusPropertVo;
import com.smart.bracelet.service.assets.BusPropertService;
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
            log.info("删除资产信息成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除资产信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除资产信息失败");
        }
    }

    @Override
    public Long insertSelective(BusPropert record) throws CustomerException {
        try {
            Long l = IdUtils.nextId();
            record.setPropertId(l);
            int insertSelective = busPropertDao.insertSelective(record);
            log.info("新增资产信息成功,受影响行数:{}", insertSelective);
            return l;
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
            log.info("更新资产信息成功,受影响行数:{}", updateByPrimaryKeySelective);
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

    @Override
    public int updateStatus(String status, String checkReason, Long propertId) throws CustomerException {
        try {
            int i = busPropertDao.updateStatus(status, checkReason, propertId);
            log.info("更新状态成功,受影响行数:{}", i);
            return i;
        } catch (Exception e) {
            log.error("更新状态失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新状态失败");
        }
    }

    @Override
    public List<AssetsDebtBank> querys(AssetsMyDebt assetsMyDebt) {
        if(assetsMyDebt.getCompanyType().equals("1")){
            assetsMyDebt.setCompanyType(null);
        }
        return busPropertDao.querys(assetsMyDebt);
    }
}
