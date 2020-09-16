package com.smart.bracelet.service.doc.impl;

import com.smart.bracelet.dao.doc.BusElectronUsernoDao;
import com.smart.bracelet.dao.doc.BusEletronUserDao;
import com.smart.bracelet.model.po.doc.BusEletronUser;
import com.smart.bracelet.service.doc.BusElectronUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusElectronUserServiceImpl implements BusElectronUserService {
    @Autowired
    private BusEletronUserDao busEletronUserDao;
    @Override
    public int deleteByPrimaryKey(String acctId) {
        int i = busEletronUserDao.deleteByPrimaryKey(acctId);
        return i;
    }

    @Override
    public int insert(BusEletronUser record) {
        int i = busEletronUserDao.insert(record);
        return i;
    }

    @Override
    public int insertSelective(BusEletronUser record) {
        int i = busEletronUserDao.insertSelective(record);
        return i;
    }

    @Override
    public BusEletronUser selectByPrimaryKey(String acctId) {
        BusEletronUser busEletronUser = busEletronUserDao.selectByPrimaryKey(acctId);
        return busEletronUser;
    }

    @Override
    public int updateByPrimaryKeySelective(BusEletronUser record) {
        int i = busEletronUserDao.updateByPrimaryKeySelective(record);
        return i;
    }

    @Override
    public int updateByPrimaryKey(BusEletronUser record) {
        int i = busEletronUserDao.updateByPrimaryKey(record);
        return i;
    }

    @Override
    public BusEletronUser selectByPartaCard(String partaCard) {
        BusEletronUser busEletronUser = busEletronUserDao.selectByPartaCard(partaCard);
        return busEletronUser;
    }
}
