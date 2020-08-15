package com.smart.bracelet.service.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubCompany;
import com.smart.bracelet.model.vo.user.PubCompanyVo;

import java.util.List;

public interface PubCompanyService {

    int deleteByPrimaryKey(Long companyId) throws CustomerException;

    int insertSelective(PubCompany record) throws CustomerException;

    PubCompany selectByPrimaryKey(Long companyId);

    int updateByPrimaryKeySelective(PubCompanyVo record) throws CustomerException;

    List<PubCompany> queryList();
}
