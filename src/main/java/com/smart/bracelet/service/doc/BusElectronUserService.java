package com.smart.bracelet.service.doc;

import com.smart.bracelet.model.po.doc.BusEletronUser;

public interface BusElectronUserService {
    int deleteByPrimaryKey(String acctId);

    int insert(BusEletronUser record);

    int insertSelective(BusEletronUser record);

    BusEletronUser selectByPrimaryKey(String acctId);

    int updateByPrimaryKeySelective(BusEletronUser record);

    int updateByPrimaryKey(BusEletronUser record);

    BusEletronUser selectByPartaCard(String partaCard);
}
