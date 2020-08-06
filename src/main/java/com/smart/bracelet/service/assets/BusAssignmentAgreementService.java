package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAssignmentAgreement;
import com.smart.bracelet.model.vo.assets.BusAssignmentAgreementVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusAssignmentAgreementService {

    int deleteByPrimaryKey(Long assignmentAgreementId) throws CustomerException;

    int insertSelective(BusAssignmentAgreement record) throws CustomerException;

    BusAssignmentAgreement selectByPrimaryKey(Long assignmentAgreementId);

    int updateByPrimaryKeySelective(BusAssignmentAgreementVo record) throws CustomerException;

    List<BusAssignmentAgreement> queryList();

}