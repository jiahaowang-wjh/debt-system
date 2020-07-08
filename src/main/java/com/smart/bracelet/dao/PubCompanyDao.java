package com.smart.bracelet.dao;

import com.smart.bracelet.model.po.PubCompany;
import org.springframework.stereotype.Repository;

@Repository
public interface PubCompanyDao {
    int deleteByPrimaryKey(Long companyId);

    int insert(PubCompany record);

    int insertSelective(PubCompany record);

    PubCompany selectByPrimaryKey(Long companyId);

    int updateByPrimaryKeySelective(PubCompany record);

    int updateByPrimaryKey(PubCompany record);
}