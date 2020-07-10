package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusRelativePersonDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusRelativePerson;
import com.smart.bracelet.model.vo.debt.BusRelativePersonVo;
import com.smart.bracelet.service.debt.BusRelativePersonService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusRelativePersonServiceImpl implements BusRelativePersonService {

    @Autowired
    private BusRelativePersonDao busRelativePerson;

    @Override
    public int deleteByPrimaryKey(Long relativePerId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busRelativePerson.deleteByPrimaryKey(relativePerId);
            log.info("删除相对信息成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除相对信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("删除相对信息失败");
        }
    }

    @Override
    public int insertSelective(BusRelativePerson record) throws CustomerException {
        try {
            record.setRelativePerId(IdUtils.nextId());
            int insertSelective = busRelativePerson.insertSelective(record);
            log.info("新增相对信息成功,受影响行数:{}",insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增相对信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增相对信息失败");
        }
    }

    @Override
    public BusRelativePerson selectByPrimaryKey(Long relativePerId) {
        return busRelativePerson.selectByPrimaryKey(relativePerId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusRelativePersonVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = busRelativePerson.updateByPrimaryKeySelective(record);
            log.info("更新相对人信息成功,受影响行数:{}",updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新相对人信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("更新相对人信息失败");
        }
    }
}
