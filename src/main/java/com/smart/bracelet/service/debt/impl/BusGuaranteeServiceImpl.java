package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusGuaranteeDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusGuarantee;
import com.smart.bracelet.model.vo.debt.BusGuaranteeVo;
import com.smart.bracelet.service.debt.BusGuaranteeService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusGuaranteeServiceImpl implements BusGuaranteeService {

    @Autowired
    private BusGuaranteeDao busGuaranteeDao;

    @Override
    public int deleteByPrimaryKey(Long guaranteeId) throws CustomerException {

        try {
            int deleteByPrimaryKey = busGuaranteeDao.deleteByPrimaryKey(guaranteeId);
            log.info("删除担保人信息成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除担保人信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("删除担保人信息失败");
        }
    }

    @Override
    public int insertSelective(BusGuarantee record) throws CustomerException {
        try {
            record.setGuaranteeId(IdUtils.nextId());
            int insertSelective = busGuaranteeDao.insertSelective(record);
            log.info("新增担保人信息成功,受影响行数:{}",insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增担保人信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增担保人信息失败");
        }
    }

    @Override
    public BusGuarantee selectByPrimaryKey(Long guaranteeId) {
        return busGuaranteeDao.selectByPrimaryKey(guaranteeId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusGuaranteeVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = busGuaranteeDao.updateByPrimaryKeySelective(record);
            log.info("更新担保人信息成功,受影响行数:{}",updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新担保人信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("更新担保人信息失败");
        }
    }
}
