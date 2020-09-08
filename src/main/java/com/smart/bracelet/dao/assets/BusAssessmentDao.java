package com.smart.bracelet.dao.assets;

import com.smart.bracelet.model.po.assets.BusAssessment;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.assets.BusAssessmentInit;
import com.smart.bracelet.model.vo.assets.BusAssessmentVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusAssessmentDao {
    int deleteByPrimaryKey(Long assessmentId);

    int insertSelective(BusAssessment record);

    BusAssessment selectByPrimaryKey(Long assessmentId);

    int updateByPrimaryKeySelective(BusAssessmentVo record);

    /**
     * 获取最后一条编号
     * @return
     */
    String selectNo();

    List<DateAndDays> selectDaysCount();

    /**
     * 资产评估页面初始化
     */
    BusAssessmentInit initialize(Long relativePerId);
}