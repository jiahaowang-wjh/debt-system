package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAssessment;
import com.smart.bracelet.model.vo.assets.BusAssessmentVo;

public interface BusAssessmentService {
    int deleteByPrimaryKey(Long assessmentId) throws CustomerException;

    int insertSelective(BusAssessment record) throws CustomerException;

    BusAssessment selectByPrimaryKey(Long assessmentId);

    int updateByPrimaryKeySelective(BusAssessmentVo record) throws CustomerException;

}