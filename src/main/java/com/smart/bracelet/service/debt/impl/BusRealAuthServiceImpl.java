package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusRealAuthDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusRealAuth;
import com.smart.bracelet.model.vo.debt.BusRealAuthVo;
import com.smart.bracelet.service.debt.BusRealAuthService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusRealAuthServiceImpl implements BusRealAuthService {

    @Autowired
    private BusRealAuthDao busRealAuthDao;

    @Override
    public int deleteByPrimaryKey(Long realId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busRealAuthDao.deleteByPrimaryKey(realId);
            log.info("删除实名认证成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除实名认证失败,异常信息:{}",e.getMessage());
            throw new CustomerException("删除实名认证失败");
        }
    }

    @Override
    public int insertSelective(BusRealAuth record) throws CustomerException {
        try {
            record.setRealId(IdUtils.nextId());
            int insertSelective = busRealAuthDao.insertSelective(record);
            log.info("新增实名认证信息成功,受影响行数:{}",insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增实名认证信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增实名认证信息失败");
        }
    }

    @Override
    public BusRealAuth selectByPrimaryKey(Long realId) {
        return busRealAuthDao.selectByPrimaryKey(realId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusRealAuthVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = busRealAuthDao.updateByPrimaryKeySelective(record);
            log.info("更新实名认证信息成功,受影响行数:{}",updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新实名认证信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("更新实名认证信息失败");
        }
    }
}
