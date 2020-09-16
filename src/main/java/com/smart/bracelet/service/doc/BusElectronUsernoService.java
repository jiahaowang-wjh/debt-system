package com.smart.bracelet.service.doc;

import com.smart.bracelet.model.po.doc.BusElectronUserno;

public interface BusElectronUsernoService {
    int deleteByPrimaryKey(Long userno);

    int insert(BusElectronUserno record);

    int insertSelective(BusElectronUserno record);

    BusElectronUserno selectByPrimaryKey(Long userno);

    BusElectronUserno selectByPrimaryNotype(String notype);

    int updateByPrimaryKey(BusElectronUserno record);
}
