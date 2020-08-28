package com.smart.bracelet.service.assets.impl;

import com.smart.bracelet.dao.assets.BusAssessmentDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAssessment;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.assets.BusAssessmentVo;
import com.smart.bracelet.service.assets.BusAssessmentService;
import com.smart.bracelet.utils.IdUtils;
import com.smart.bracelet.utils.RepNoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BusAssessmentServiceImpl implements BusAssessmentService {

    @Autowired
    private BusAssessmentDao busAssessmentDao;

    @Override
    public int deleteByPrimaryKey(Long assessmentId) throws CustomerException {
        try {
            int i = busAssessmentDao.deleteByPrimaryKey(assessmentId);
            return i;
        } catch (Exception e) {
            log.error("删除资产评估失败异常信息:{}",e.getMessage());
           throw new CustomerException("删除资产评估失败");
        }
    }

    @Override
    public int insertSelective(BusAssessment record) throws CustomerException {
        try {
            record.setAssessmentId(IdUtils.nextId());
            String selectNo = busAssessmentDao.selectNo();
            record.setAssessmentNo(RepNoUtils.createRepNo("TZ","ZCPG",selectNo));
            int i = busAssessmentDao.insertSelective(record);
            return i;
        } catch (Exception e) {
            log.error("新增资产评估失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增资产评估失败");
        }
    }

    @Override
    public BusAssessment selectByPrimaryKey(Long assessmentId) {
        BusAssessment busAssessment = busAssessmentDao.selectByPrimaryKey(assessmentId);
        return busAssessment;
    }

    @Override
    public int updateByPrimaryKeySelective(BusAssessmentVo record) throws CustomerException {
        try {
            int i = busAssessmentDao.updateByPrimaryKeySelective(record);
            return i;
        } catch (Exception e) {
            log.error("更新资产评估失败,异常信息:{}",e.getMessage());
            throw new CustomerException("更新资产评估失败");
        }
    }

    @Override
    public List<DateAndDays> selectDaysCount() {
        return busAssessmentDao.selectDaysCount();
    }
}
