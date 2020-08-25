package com.smart.bracelet.dao.assets;

import com.smart.bracelet.model.po.assets.BusAssessment;
import com.smart.bracelet.model.vo.assets.BusAssessmentVo;
import org.springframework.stereotype.Repository;

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
}