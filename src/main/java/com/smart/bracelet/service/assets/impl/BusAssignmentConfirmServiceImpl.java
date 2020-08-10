package com.smart.bracelet.service.assets.impl;

import com.smart.bracelet.dao.assets.BusAssignmentConfirmDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAssignmentConfirm;
import com.smart.bracelet.model.vo.assets.BusAssignmentConfirmVo;
import com.smart.bracelet.service.assets.BusAssignmentConfirmService;
import com.smart.bracelet.utils.IdUtils;
import io.micrometer.core.instrument.Meter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class BusAssignmentConfirmServiceImpl implements BusAssignmentConfirmService {

    @Autowired
    private BusAssignmentConfirmDao busAssignmentConfirmDao;

    @Override
    public int deleteByPrimaryKey(Long posseConfirmtId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busAssignmentConfirmDao.deleteByPrimaryKey(posseConfirmtId);
            log.info("删除资产债权转让确认成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除资产债权转让确认失败,异常信息:{}",e.getMessage());
            throw new CustomerException("删除资产债权转让确认失败");
        }
    }

    @Override
    public int insertSelective(BusAssignmentConfirm record) throws CustomerException {
        try {
            record.setPosseConfirmtId(IdUtils.nextId());
            int deleteByPrimaryKey = busAssignmentConfirmDao.insertSelective(record);
            log.info("新增资产债权转让确认成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("新增资产债权转让确认失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增资产债权转让确认失败");
        }
    }

    @Override
    public BusAssignmentConfirm selectByPrimaryKey(Long posseConfirmtId) {
        return busAssignmentConfirmDao.selectByPrimaryKey(posseConfirmtId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusAssignmentConfirmVo record) throws CustomerException {
        try {
            int deleteByPrimaryKey = busAssignmentConfirmDao.updateByPrimaryKeySelective(record);
            log.info("更新资产债权转让确认成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("更新资产债权转让确认失败,异常信息:{}",e.getMessage());
            throw new CustomerException("更新资产债权转让确认失败");
        }
    }

    @Override
    public List<BusAssignmentConfirm> queryList() {
        return busAssignmentConfirmDao.queryList();
    }
}