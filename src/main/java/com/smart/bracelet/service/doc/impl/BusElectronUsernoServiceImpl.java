package com.smart.bracelet.service.doc.impl;

import com.smart.bracelet.dao.doc.BusElectronSealDao;
import com.smart.bracelet.dao.doc.BusElectronUsernoDao;
import com.smart.bracelet.model.po.doc.BusElectronSeal;
import com.smart.bracelet.model.po.doc.BusElectronUserno;
import com.smart.bracelet.service.doc.BusElectronSealService;
import com.smart.bracelet.service.doc.BusElectronUsernoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusElectronUsernoServiceImpl implements BusElectronUsernoService {
    @Autowired
    private BusElectronUsernoDao busElectronUsernoDao;
    @Override
    public int deleteByPrimaryKey(Long userno) {
        int i = busElectronUsernoDao.deleteByPrimaryKey(userno);
        return i;
    }

    @Override
    public int insert(BusElectronUserno record) {
        int i = busElectronUsernoDao.insert(record);
        return i;
    }

    @Override
    public int insertSelective(BusElectronUserno record) {
        int i = busElectronUsernoDao.insertSelective(record);
        return i;
    }

    @Override
    public BusElectronUserno selectByPrimaryKey(Long userno) {
        BusElectronUserno busElectronUserno = busElectronUsernoDao.selectByPrimaryKey(userno);
        return busElectronUserno;
    }

    @Override
    public BusElectronUserno selectByPrimaryNotype(String notype) {
        BusElectronUserno busElectronUserno = busElectronUsernoDao.selectByPrimaryNotype(notype);
        return busElectronUserno;
    }

    @Override
    public int updateByPrimaryKey(BusElectronUserno record) {
        int i = busElectronUsernoDao.updateByPrimaryKey(record);
        return i;
    }
}
