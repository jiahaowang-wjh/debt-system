package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.vo.debt.*;

import java.util.List;

public interface BusRelativePersonService {
    int deleteByPrimaryKey(Long relativePerId) throws CustomerException;

    BusRelativePersonListVo selectByPrimaryKey(Long relativePerId);

    List<BusRelativePersonListVo> queryListVo();

    /**
     * 新增私人相对人
     */
    int insertPrivate(BusRelativePersonPrivateVo busRelativePersonPrivateVo) throws CustomerException;

    /**
     * 更新私人相对人
     */
    int updatePrivate(BusRelativePersonPrivateUpdateVo busRelativePersonPrivateVo) throws CustomerException;


    /**
     * 新增企业相对人
     */
    int insertEnterprise(BusRelativePersonEnterpriseVo busRelativePersonEnterpriseVo) throws CustomerException;

    /**
     * 更新企业相对人
     */
    int updateEnterprise(BusRelativePersonEnterpriseUpdateVo busRelativePersonEnterpriseVo) throws CustomerException;

    /**
     * 新增银行相对人
     */
    int insertBank(BusRelativePersonBankVo busRelativePersonBankVo) throws CustomerException;

    /**
     * 更新银行相对人
     */
    int updateBank(BusRelativePersonBankUpdateVo busRelativePersonBankVo) throws CustomerException;

    /**
     * 根据报备ID查询相对人信息
     */
    List<BusRelativePersonListVo> selectByreportId(Long reportId);

    /**
     * 通过相对人ID查询相对人债事人信息
     * @param relativePerId
     * @return
     */
    ReportAndRelativePersonShow selectByRelativePerId(Long relativePerId) throws CustomerException;


}
