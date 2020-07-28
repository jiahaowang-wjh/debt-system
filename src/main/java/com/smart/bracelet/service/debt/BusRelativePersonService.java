package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusRelativePerson;
import com.smart.bracelet.model.vo.debt.BusRelativePersonBankVo;
import com.smart.bracelet.model.vo.debt.BusRelativePersonEnterpriseVo;
import com.smart.bracelet.model.vo.debt.BusRelativePersonPrivateVo;
import com.smart.bracelet.model.vo.debt.BusRelativePersonVo;

public interface BusRelativePersonService {
    int deleteByPrimaryKey(Long relativePerId) throws CustomerException;

    BusRelativePerson selectByPrimaryKey(Long relativePerId);

    int updateByPrimaryKeySelective(BusRelativePersonVo record) throws CustomerException;

    /**
     * 新增私人相对人
     */
    int insertPrivate(BusRelativePersonPrivateVo busRelativePersonPrivateVo) throws CustomerException;

    /**
     * 新增企业相对人
     */
    int insertEnterprise(BusRelativePersonEnterpriseVo busRelativePersonEnterpriseVo) throws CustomerException;

    /**
     * 新增银行相对人
     */
    int insertBank(BusRelativePersonBankVo busRelativePersonBankVo) throws CustomerException;

}
