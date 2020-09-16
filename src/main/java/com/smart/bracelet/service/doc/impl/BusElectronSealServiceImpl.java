package com.smart.bracelet.service.doc.impl;

import com.smart.bracelet.dao.doc.BusElectronSealDao;
import com.smart.bracelet.model.po.doc.BusElectronSeal;
import com.smart.bracelet.service.doc.BusElectronSealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusElectronSealServiceImpl implements BusElectronSealService {

    @Autowired
    private BusElectronSealDao busElectronSealDao;
    @Override
    public int deleteByPrimaryKey(Long electronSealId) {
        int i = busElectronSealDao.deleteByPrimaryKey(electronSealId);
        return i;
    }

    @Override
    public int insert(BusElectronSeal record) {
        int i = busElectronSealDao.insert(record);
        return i;
    }

    @Override
    public int insertSelective(BusElectronSeal record) {
        int i = busElectronSealDao.insertSelective(record);
        return i;
    }

    @Override
    public BusElectronSeal selectByPrimaryKey(Long electronSealId) {
        BusElectronSeal busElectronSeal = busElectronSealDao.selectByPrimaryKey(electronSealId);
        return busElectronSeal;
    }

    @Override
    public int updateByPrimaryKeySelective(BusElectronSeal record) {
        int i = busElectronSealDao.updateByPrimaryKeySelective(record);
        return i;
    }

    @Override
    public int updateByPrimaryKey(BusElectronSeal record) {
        int i = busElectronSealDao.updateByPrimaryKey(record);
        return i;
    }
}
