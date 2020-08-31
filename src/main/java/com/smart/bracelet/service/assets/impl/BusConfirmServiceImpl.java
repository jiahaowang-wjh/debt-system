package com.smart.bracelet.service.assets.impl;

import com.smart.bracelet.dao.assets.BusConfirmDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusConfirm;
import com.smart.bracelet.model.vo.assets.BusConfirmShow;
import com.smart.bracelet.model.vo.assets.BusConfirmVo;
import com.smart.bracelet.service.assets.BusConfirmService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BusConfirmServiceImpl implements BusConfirmService {

    @Autowired
    private BusConfirmDao busConfirmDao;

    @Override
    public int deleteByPrimaryKey(Long confirmtId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busConfirmDao.deleteByPrimaryKey(confirmtId);
            log.info("删除资产债权确认成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除资产债权确认失败,异常信息:{}",e.getMessage());
            throw new CustomerException("删除资产债权确认失败");
        }
    }

    @Override
    public int insertSelective(BusConfirm record) throws CustomerException {
        try {
            record.setConfirmtId(IdUtils.nextId());
            int deleteByPrimaryKey = busConfirmDao.insertSelective(record);
            log.info("新增资产债权确认成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("新增资产债权确认失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增资产债权确认失败");
        }
    }

    @Override
    public BusConfirm selectByPrimaryKey(Long confirmtId) {
        return busConfirmDao.selectByPrimaryKey(confirmtId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusConfirmVo record) throws CustomerException {
        try {
            int deleteByPrimaryKey = busConfirmDao.updateByPrimaryKeySelective(record);
            log.info("更新资产债权确认成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("更新资产债权确认失败,异常信息:{}",e.getMessage());
            throw new CustomerException("更新资产债权确认失败");
        }
    }

    @Override
    public List<BusConfirm> queryList() {
        return busConfirmDao.queryList();
    }

    @Override
    public BusConfirmShow initialize(Long relativePerId) {
        return busConfirmDao.initialize(relativePerId);
    }
}
