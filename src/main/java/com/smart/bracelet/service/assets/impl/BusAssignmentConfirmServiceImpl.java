package com.smart.bracelet.service.assets.impl;


import com.smart.bracelet.dao.assets.BusAssignmentAgreementDao;
import com.smart.bracelet.dao.assets.BusAssignmentConfirmDao;

import com.smart.bracelet.dao.debt.BusGuaranteeDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAssignmentConfirm;
import com.smart.bracelet.model.po.debt.BusGuarantee;
import com.smart.bracelet.model.vo.assets.BusAssignmentConfirmShow;
import com.smart.bracelet.model.vo.assets.BusAssignmentConfirmVo;
import com.smart.bracelet.service.assets.BusAssignmentConfirmService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BusAssignmentConfirmServiceImpl implements BusAssignmentConfirmService {

    @Autowired
    private BusAssignmentConfirmDao busAssignmentConfirmDao;

    @Autowired
    private BusGuaranteeDao busGuaranteeDao;

    @Autowired
    private BusAssignmentAgreementDao assignmentAgreementDao;

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long posseConfirmtId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busAssignmentConfirmDao.deleteByPrimaryKey(posseConfirmtId);
            log.info("删除资产债权转让确认成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除资产债权转让确认失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除资产债权转让确认失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public Long insertSelective(BusAssignmentConfirm record) throws CustomerException {
        try {
            long l = IdUtils.nextId();
            record.setPosseConfirmtId(l);
            int deleteByPrimaryKey = busAssignmentConfirmDao.insertSelective(record);
            log.info("新增资产债权转让确认成功,受影响行数:{}", deleteByPrimaryKey);
            return l;
        } catch (Exception e) {
            log.error("新增资产债权转让确认失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增资产债权转让确认失败");
        }
    }

    @Override
    public BusAssignmentConfirm selectByPrimaryKey(Long posseConfirmtId) {
        return busAssignmentConfirmDao.selectByPrimaryKey(posseConfirmtId);
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(BusAssignmentConfirmVo record) throws CustomerException {
        try {
            int deleteByPrimaryKey = busAssignmentConfirmDao.updateByPrimaryKeySelective(record);
            log.info("更新资产债权转让确认成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("更新资产债权转让确认失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新资产债权转让确认失败");
        }
    }

    @Override
    public List<BusAssignmentConfirm> queryList() {
        return busAssignmentConfirmDao.queryList();
    }

    @Override
    public BusAssignmentConfirmShow initialize(Long propertId) {
        BusAssignmentConfirmShow initialize = busAssignmentConfirmDao.initialize(propertId);
        initialize.setConfirmNo(initialize.getAssignmentAgreementNo()+"(-1)");
        List<String> authName = new ArrayList<>();
        List<BusGuarantee> busGuarantees = busGuaranteeDao.selectByPrimaryKey(initialize.getCivilId());
        for (BusGuarantee item: busGuarantees) {
            authName.add(item.getAuthname());
        }
        initialize.setAuthName(authName);
        initialize.setThisTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return initialize;
    }

    @Override
    public BusAssignmentConfirm selectByPropertId(Long propertId) {
        return busAssignmentConfirmDao.selectByPropertId(propertId);
    }


}
