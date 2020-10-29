package com.smart.bracelet.dao.user;

import com.smart.bracelet.model.po.user.PubCompany;
import com.smart.bracelet.model.vo.user.PubCompanyVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PubCompanyDao {

    int deleteByPrimaryKey(Long companyId);

    int insertSelective(PubCompany record);

    PubCompany selectByPrimaryKey(Long companyId);

    int updateByPrimaryKeySelective(PubCompanyVo record);

    List<PubCompany> queryList();

    PubCompany selectByNameMax(String nameMax);
}