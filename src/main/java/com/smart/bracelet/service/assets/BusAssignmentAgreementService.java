package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAssignmentAgreement;
import com.smart.bracelet.model.vo.assets.BusAssignmentAgreementShow;
import com.smart.bracelet.model.vo.assets.BusAssignmentAgreementVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusAssignmentAgreementService {

    int deleteByPrimaryKey(Long assignmentAgreementId) throws CustomerException;

    Long insertSelective(BusAssignmentAgreement record) throws CustomerException;

    BusAssignmentAgreement selectByPrimaryKey(Long assignmentAgreementId);

    int updateByPrimaryKeySelective(BusAssignmentAgreementVo record) throws CustomerException;

    List<BusAssignmentAgreement> queryList();

    /**
     * 页面初始化数据
     * @param relativePerId
     * @return
     */
    BusAssignmentAgreementShow initialize(Long relativePerId) throws CustomerException;

    /**
     * 通过资产Id查询资产债权转让协议
     * @param propertId
     * @return
     */
    BusAssignmentAgreement selectByProId(Long propertId);
}