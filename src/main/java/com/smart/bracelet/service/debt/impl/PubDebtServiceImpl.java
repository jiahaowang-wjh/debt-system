package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.PubDebtDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.PubDebt;
import com.smart.bracelet.model.vo.debt.PubDebtVo;
import com.smart.bracelet.service.debt.PubDebtService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PubDebtServiceImpl implements PubDebtService {

    @Autowired
    private PubDebtDao pubDebtDao;

    @Override
    public int deleteByPrimaryKey(Long debtId) throws CustomerException {
        try {
            int deleteByPrimaryKey = pubDebtDao.deleteByPrimaryKey(debtId);
            log.info("删除借债信息成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除解债信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("删除解债信息失败");
        }
    }

    @Override
    public int insertSelective(PubDebt record) throws CustomerException {
        try {
            record.setDebtId(IdUtils.nextId());
            int insertSelective = pubDebtDao.insertSelective(record);
            log.info("新增解债信息成功,受影响行数:{}",insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增解债信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增解债信息失败");
        }
    }

    @Override
    public PubDebt selectByPrimaryKey(Long debtId) {
        return pubDebtDao.selectByPrimaryKey(debtId);
    }

    @Override
    public int updateByPrimaryKeySelective(PubDebtVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = pubDebtDao.updateByPrimaryKeySelective(record);
            log.info("更新解债信息成功,受影响行数:{}",updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新解债信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("更新解债信息失败");
        }
    }
}
