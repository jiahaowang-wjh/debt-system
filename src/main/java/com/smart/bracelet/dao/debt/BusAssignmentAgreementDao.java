package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusAssignmentAgreement;
import com.smart.bracelet.model.vo.debt.BusAssignmentAgreementVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusAssignmentAgreementDao {
    int deleteByPrimaryKey(Long assignmentAgreementId);

    int insertSelective(BusAssignmentAgreement record);

    BusAssignmentAgreement selectByPrimaryKey(Long assignmentAgreementId);

    int updateByPrimaryKeySelective(BusAssignmentAgreementVo record);

    List<BusAssignmentAgreement> queryList();
}