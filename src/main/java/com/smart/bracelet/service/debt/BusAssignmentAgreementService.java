package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusAssignmentAgreement;
import com.smart.bracelet.model.vo.debt.BusAssignmentAgreementVo;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BusAssignmentAgreementService {
    int deleteByPrimaryKey(Long assignmentAgreementId) throws CustomerException;

    int insertSelective(BusAssignmentAgreement record) throws CustomerException;

    BusAssignmentAgreement selectByPrimaryKey(Long assignmentAgreementId);

    int updateByPrimaryKeySelective(BusAssignmentAgreementVo record) throws CustomerException;

    List<BusAssignmentAgreement> queryList();
}