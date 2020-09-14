package com.smart.bracelet.dao.doc;

import com.smart.bracelet.model.po.doc.BusElectronSeal;
import com.smart.bracelet.model.po.doc.BusElectronUserno;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

@Repository
public interface BusElectronUsernoDao {
    int deleteByPrimaryKey(Long userno);

    int insert(BusElectronUserno record);

    int insertSelective(BusElectronUserno record);

    BusElectronUserno selectByPrimaryKey(Long userno);

    BusElectronUserno selectByPrimaryNotype(String notype);

    int updateByPrimaryKey(BusElectronUserno record);
}