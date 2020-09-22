package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAssessment;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.assets.BusAssessmentInit;
import com.smart.bracelet.model.vo.assets.BusAssessmentVo;

import java.util.List;

public interface BusAssessmentService {
    int deleteByPrimaryKey(Long assessmentId) throws CustomerException;

    Long insertSelective(BusAssessment record) throws CustomerException;

    BusAssessment selectByPrimaryKey(Long assessmentId);

    int updateByPrimaryKeySelective(BusAssessmentVo record) throws CustomerException;

    List<DateAndDays> selectDaysCount(String type,Long comId);


    /**
     * 资产评估页面初始化
     */
    BusAssessmentInit initialize(Long relativePerId);

    /**
     * 通过资产id获取资产评估信息
     */
    BusAssessment selectByPropertId(Long propertId);
}