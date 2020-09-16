package com.smart.bracelet.service.doc;

import com.smart.bracelet.model.po.doc.BusElectronSeal;

public interface BusElectronSealService {
    int deleteByPrimaryKey(Long electronSealId);

    int insert(BusElectronSeal record);

    int insertSelective(BusElectronSeal record);

    BusElectronSeal selectByPrimaryKey(Long electronSealId);

    int updateByPrimaryKeySelective(BusElectronSeal record);

    int updateByPrimaryKey(BusElectronSeal record);
}
