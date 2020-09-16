package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusMediatePersonDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusMediatePerson;
import com.smart.bracelet.model.vo.debt.BusMediatePersonVo;
import com.smart.bracelet.service.debt.BusMediatePersonService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class BusMediatePersonServiceImpl implements BusMediatePersonService {

    @Autowired
    private BusMediatePersonDao busMediatePersonDao;

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long mediatePersonId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busMediatePersonDao.deleteByPrimaryKey(mediatePersonId);
            log.info("删除调解参与人信息表成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除调解参与人信息表失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除调解参与人信息表失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int insertSelective(BusMediatePerson record) throws CustomerException {
        try {
            record.setMediatePersonId(IdUtils.nextId());
            int insertSelective = busMediatePersonDao.insertSelective(record);
            log.info("新增调解参与人信息表成功,受影响行数:{}", insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增调解参与人信息表失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增调解参与人信息表失败");
        }
    }

    @Override
    public BusMediatePerson selectByPrimaryKey(Long mediatePersonId) {
        return busMediatePersonDao.selectByPrimaryKey(mediatePersonId);
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(BusMediatePersonVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = busMediatePersonDao.updateByPrimaryKeySelective(record);
            log.info("更新调解参与人信息表成功,受影响行数:{}", updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新调解参与人信息表失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新调解参与人信息表失败");
        }
    }

    @Override
    public List<BusMediatePerson> queryList() {
        return busMediatePersonDao.queryList();
    }
}
