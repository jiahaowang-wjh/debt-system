package com.smart.bracelet.service.assets.impl;

import com.smart.bracelet.dao.assets.BusCollectionLetterDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusCollectionLetter;
import com.smart.bracelet.model.vo.assets.BusCollectionLetterVo;
import com.smart.bracelet.service.assets.BusCollectionLetterService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BusCollectionLetterServiceImpl implements BusCollectionLetterService {

    @Autowired
    private BusCollectionLetterDao busCollectionLetterDao;

    @Override
    public int deleteByPrimaryKey(Long collectionLettertId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busCollectionLetterDao.deleteByPrimaryKey(collectionLettertId);
            log.info("删除资产催款函成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除资产催款函失败,异常信息:{}",e.getMessage());
            throw new CustomerException("删除资产催款函失败");
        }
    }

    @Override
    public int insertSelective(BusCollectionLetter record) throws CustomerException {
        try {
            record.setCollectionLettertId(IdUtils.nextId());
            int deleteByPrimaryKey = busCollectionLetterDao.insertSelective(record);
            log.info("新增资产催款函成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("新增资产催款函失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增资产催款函失败");
        }
    }

    @Override
    public BusCollectionLetter selectByPrimaryKey(Long collectionLettertId) {
        return busCollectionLetterDao.selectByPrimaryKey(collectionLettertId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusCollectionLetterVo record) throws CustomerException {
        try {
            int deleteByPrimaryKey = busCollectionLetterDao.updateByPrimaryKeySelective(record);
            log.info("更新资产催款函成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("更新资产催款函失败,异常信息:{}",e.getMessage());
            throw new CustomerException("更新资产催款函失败");
        }
    }

    @Override
    public List<BusCollectionLetter> queryList() {
        return busCollectionLetterDao.queryList();
    }
}