package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusCivilDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusCivil;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.debt.BusCivilVo;
import com.smart.bracelet.service.debt.BusCivilService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BusCivilServiceImpl implements BusCivilService {

    @Autowired
    private BusCivilDao busCivilDao;

    @Override
    public int deleteByPrimaryKey(Long civilId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busCivilDao.deleteByPrimaryKey(civilId);
            log.info("删除民事调解信息成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除民事调解信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("删除民事调解信息失");
        }
    }

    @Override
    public int insertSelective(BusCivil record) throws CustomerException {
        try {
            record.setCivilId(IdUtils.nextId());
            int insertSelective = busCivilDao.insertSelective(record);
            log.info("新增民事调解信息成功,受影响行数:{}",insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增民事调解信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增民事调解信息失败");
        }
    }

    @Override
    public BusCivil selectByPrimaryKey(Long civilId) {
        return busCivilDao.selectByPrimaryKey(civilId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusCivilVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = busCivilDao.updateByPrimaryKeySelective(record);
            log.info("更新民事调解信息成功,受影响行数:{}",updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新民事调解信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("更新民事调解信息失败");
        }
    }

    /**
     * 查询民事调节信息并按照日期分组
     * @return
     */
    @Override
    public List<DateAndDays> selectDaysCount() {
        return busCivilDao.selectDaysCount();
    }

    /**
     * 查询所有民事调解信息
     * @return
     */
    @Override
    public List<BusCivil> queryList() {
        return busCivilDao.queryList();
    }
}
