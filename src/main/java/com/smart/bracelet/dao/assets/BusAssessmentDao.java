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

    List<DateAndDays> selectDaysCount(String type,Long comId);

    /**
     * 资产评估页面初始化
     */
    BusAssessmentInit initialize(Long propertId);

    /**
     * 通过资产id获取资产评估信息
     */
    BusAssessment selectByPropertId(Long propertId);

}