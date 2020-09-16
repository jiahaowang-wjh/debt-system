package com.smart.bracelet.service.assets.impl;

import com.smart.bracelet.dao.assets.BusBankGuaranteDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusBankGuarante;
import com.smart.bracelet.model.vo.assets.BusBankGuaranteVo;
import com.smart.bracelet.service.assets.BusBankGuaranteService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class BusBankGuaranteServiceImpl implements BusBankGuaranteService {

    @Autowired
    private BusBankGuaranteDao busBankGuaranteDao;

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long bankGuaranteId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busBankGuaranteDao.deleteByPrimaryKey(bankGuaranteId);
            log.info("删除资产银行保函协议成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除资产银行保函协议失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除资产银行保函协议失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public Long insertSelective(BusBankGuarante record) throws CustomerException {
        try {
            long l = IdUtils.nextId();
            record.setBankGuaranteId(l);
            int deleteByPrimaryKey = busBankGuaranteDao.insertSelective(record);
            log.info("新增资产银行保函协议成功,受影响行数:{}", deleteByPrimaryKey);
            return l;
        } catch (Exception e) {
            log.error("新增资产银行保函协议失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增资产银行保函协议失败");
        }
    }

    @Override
    public BusBankGuarante selectByPrimaryKey(Long bankGuaranteId) {
        return busBankGuaranteDao.selectByPrimaryKey(bankGuaranteId);
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(BusBankGuaranteVo record) throws CustomerException {
        try {
            int deleteByPrimaryKey = busBankGuaranteDao.updateByPrimaryKeySelective(record);
            log.info("更新资产银行保函协议成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("更新资产银行保函协议失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新资产银行保函协议失败");
        }
    }

    @Override
    public List<BusBankGuarante> queryList() {
        return busBankGuaranteDao.queryList();
    }
}
