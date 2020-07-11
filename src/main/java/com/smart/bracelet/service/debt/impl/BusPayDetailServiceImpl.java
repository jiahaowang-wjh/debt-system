package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusPayDetailDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusPayDetail;
import com.smart.bracelet.model.vo.debt.BusPayDetailVo;
import com.smart.bracelet.service.debt.BusPayDetailService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusPayDetailServiceImpl implements BusPayDetailService {

    @Autowired
    private BusPayDetailDao busPayDetailDao;

    @Override
    public int deleteByPrimaryKey(Long payId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busPayDetailDao.deleteByPrimaryKey(payId);
            log.info("删除支付明细信息成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除支付明细信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("删除支付明细信息失败");
        }
    }

    @Override
    public int insertSelective(BusPayDetail record) throws CustomerException {
        try {
            record.setPayId(IdUtils.nextId());
            int insertSelective = busPayDetailDao.insertSelective(record);
            log.info("新增支付信息成功,受影响行数:{}",insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增支付信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增支付信息失败");
        }
    }

    @Override
    public BusPayDetail selectByPrimaryKey(Long payId) {
       return busPayDetailDao.selectByPrimaryKey(payId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusPayDetailVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = busPayDetailDao.updateByPrimaryKeySelective(record);
            log.info("更新支付信息成功,受影响行数:{}",updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新支付信息失败,异常信息:{}",e.getMessage());
            throw  new CustomerException("更新支付信息失败");
        }
    }
}
