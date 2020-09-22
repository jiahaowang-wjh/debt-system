package com.smart.bracelet.service.assets.impl;

import com.smart.bracelet.dao.assets.BusAssignmentAgreementDao;
import com.smart.bracelet.dao.assets.BusConfirmDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAssignmentAgreement;
import com.smart.bracelet.model.po.assets.BusConfirm;
import com.smart.bracelet.model.vo.assets.BusConfirmShow;
import com.smart.bracelet.model.vo.assets.BusConfirmVo;
import com.smart.bracelet.service.assets.BusConfirmService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class BusConfirmServiceImpl implements BusConfirmService {

    @Autowired
    private BusConfirmDao busConfirmDao;

    @Autowired
    private BusAssignmentAgreementDao busAssignmentAgreementDao;

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long confirmtId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busConfirmDao.deleteByPrimaryKey(confirmtId);
            log.info("删除资产债权确认成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除资产债权确认失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除资产债权确认失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int insertSelective(BusConfirm record) throws CustomerException {
        try {
            BusAssignmentAgreement busAssignmentAgreement = busAssignmentAgreementDao.selectByProId(record.getPropertId());
            record.setConfirmNo(busAssignmentAgreement.getAssignmentAgreementNo()+"(-3)");
            record.setConfirmtId(IdUtils.nextId());
            int deleteByPrimaryKey = busConfirmDao.insertSelective(record);
            log.info("新增资产债权确认成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("新增资产债权确认失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增资产债权确认失败");
        }
    }

    @Override
    public BusConfirm selectByPrimaryKey(Long confirmtId) {
        return busConfirmDao.selectByPrimaryKey(confirmtId);
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(BusConfirmVo record) throws CustomerException {
        try {
            int deleteByPrimaryKey = busConfirmDao.updateByPrimaryKeySelective(record);
            log.info("更新资产债权确认成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("更新资产债权确认失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新资产债权确认失败");
        }
    }

    @Override
    public List<BusConfirm> queryList() {
        return busConfirmDao.queryList();
    }

    @Override
    public BusConfirmShow initialize(Long propertId) {
        BusConfirmShow initialize = busConfirmDao.initialize(propertId);
        initialize.setConfirmNo(initialize.getAssignmentAgreementNo()+"(-3)");
        return initialize;
    }

    @Override
    public BusConfirm selectByPropertId(Long propertId) {
        return busConfirmDao.selectByPropertId(propertId);
    }
}
