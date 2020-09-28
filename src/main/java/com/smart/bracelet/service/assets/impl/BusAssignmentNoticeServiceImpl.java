package com.smart.bracelet.service.assets.impl;

import com.smart.bracelet.dao.assets.BusAssignmentAgreementDao;
import com.smart.bracelet.dao.assets.BusAssignmentNoticeDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAssignmentAgreement;
import com.smart.bracelet.model.po.assets.BusAssignmentNotice;
import com.smart.bracelet.model.vo.assets.BusAssignmentNoticeShow;
import com.smart.bracelet.model.vo.assets.BusAssignmentNoticeVo;
import com.smart.bracelet.service.assets.BusAssignmentNoticeService;
import com.smart.bracelet.utils.IdUtils;
import com.smart.bracelet.utils.RepNoUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BusAssignmentNoticeServiceImpl implements BusAssignmentNoticeService {

    @Autowired
    private BusAssignmentNoticeDao busAssignmentNoticeDao;

    @Autowired
    private BusAssignmentAgreementDao assignmentAgreementDao;
    @Override
    public int deleteByPrimaryKey(Long assignmentNoticeId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busAssignmentNoticeDao.deleteByPrimaryKey(assignmentNoticeId);
            log.info("删除资产债权转让通知书成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除资产债权转让通知书失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除资产债权转让通知书失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public Long insertSelective(BusAssignmentNotice record) throws CustomerException {
        try {
            BusAssignmentAgreement busAssignmentAgreement = assignmentAgreementDao.selectByProId(record.getPropertId());
            long l = IdUtils.nextId();
            record.setAssignmentNoticeId(l);
            record.setNoticeNo(busAssignmentAgreement.getAssignmentAgreementNo()+"-(2)");
            int deleteByPrimaryKey = busAssignmentNoticeDao.insertSelective(record);
            log.info("新增资产债权转让通知书成功,受影响行数:{}", deleteByPrimaryKey);
            return l;
        } catch (Exception e) {
            log.error("新增资产债权转让通知书失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增资产债权转让通知书失败");
        }
    }

    @Override
    public BusAssignmentNotice selectByPrimaryKey(Long assignmentNoticeId) {
        return busAssignmentNoticeDao.selectByPrimaryKey(assignmentNoticeId);
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(BusAssignmentNoticeVo record) throws CustomerException {
        try {
            int deleteByPrimaryKey = busAssignmentNoticeDao.updateByPrimaryKeySelective(record);
            log.info("更新资产债权转让通知书成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("更新资产债权转让通知书失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新资产债权转让通知书失败");
        }
    }

    @Override
    public List<BusAssignmentNotice> queryList() {
        return busAssignmentNoticeDao.queryList();
    }

    @Override
    public BusAssignmentNoticeShow initialize(Long propertId) throws ParseException {
        BusAssignmentNoticeShow initialize = busAssignmentNoticeDao.initialize(propertId);
        if(StringUtils.isEmpty(initialize.getNoticeNo())){
            initialize.setNoticeNo(initialize.getAssignmentAgreementNo()+"(-2)");
            initialize.setContractTime(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
        }

        return initialize;
    }

    @Override
    public BusAssignmentNotice selectByPropertId(Long propertId) {
        return busAssignmentNoticeDao.selectByPropertId(propertId);
    }
}
