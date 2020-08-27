package com.smart.bracelet.dao.assets;

import com.smart.bracelet.model.po.assets.BusAssignmentAgreement;
import com.smart.bracelet.model.vo.assets.BusAssignmentAgreementShow;
import com.smart.bracelet.model.vo.assets.BusAssignmentAgreementVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusAssignmentAgreementDao {

    int deleteByPrimaryKey(Long assignmentAgreementId);

    int insertSelective(BusAssignmentAgreement record);

    BusAssignmentAgreement selectByPrimaryKey(Long assignmentAgreementId);

    int updateByPrimaryKeySelective(BusAssignmentAgreementVo record);

    List<BusAssignmentAgreement> queryList();

    /**
     * 查询最后一条编号记录
     * @return
     */
    String selectNo();

    /**
     * 页面初始化数据
     * @param reportId  报备ID
     * @return
     */
    BusAssignmentAgreementShow initialize(Long reportId);

}