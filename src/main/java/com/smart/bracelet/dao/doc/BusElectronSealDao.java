package com.smart.bracelet.dao.doc;

import com.smart.bracelet.model.po.doc.BusElectronSeal;
import org.springframework.stereotype.Repository;

@Repository
public interface BusElectronSealDao {
    int deleteByPrimaryKey(Long electronSealId);

    int insert(BusElectronSeal record);

    int insertSelective(BusElectronSeal record);

    BusElectronSeal selectByPrimaryKey(Long electronSealId);

    int updateByPrimaryKeySelective(BusElectronSeal record);

    int updateByPrimaryKey(BusElectronSeal record);

    BusElectronSeal selectByDocId(Long docId);
}