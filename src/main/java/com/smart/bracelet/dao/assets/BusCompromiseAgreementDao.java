package com.smart.bracelet.dao.assets;

import com.smart.bracelet.model.po.assets.BusCompromiseAgreement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusCompromiseAgreementDao {
    int deleteByPrimaryKey(Long compromiseAgreementId);

    int insertSelective(BusCompromiseAgreement record);

    BusCompromiseAgreement selectByPrimaryKey(Long compromiseAgreementId);

    int updateByPrimaryKeySelective(BusCompromiseAgreement record);

    List<BusCompromiseAgreement> queryList();

    /**
     * 查询最后一条编号
     */
    String selectNo();
}