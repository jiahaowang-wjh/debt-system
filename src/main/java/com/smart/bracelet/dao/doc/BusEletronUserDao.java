package com.smart.bracelet.dao.doc;

import com.smart.bracelet.model.po.doc.BusEletronUser;
import org.springframework.stereotype.Repository;

@Repository
public interface BusEletronUserDao {
    int deleteByPrimaryKey(String acctId);

    int insert(BusEletronUser record);

    int insertSelective(BusEletronUser record);

    BusEletronUser selectByPrimaryKey(String acctId);

    int updateByPrimaryKeySelective(BusEletronUser record);

    int updateByPrimaryKey(BusEletronUser record);

    BusEletronUser selectByPartaCard(String partaCard);
}