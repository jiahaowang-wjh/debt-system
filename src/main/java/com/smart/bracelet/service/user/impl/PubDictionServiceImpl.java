package com.smart.bracelet.service.user.impl;

import com.smart.bracelet.dao.user.PubDictionDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubDiction;
import com.smart.bracelet.model.vo.user.PubDictionVo;
import com.smart.bracelet.service.user.PubDictionService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典业务层
 */
@Service
@Slf4j
public class PubDictionServiceImpl implements PubDictionService {

    @Autowired
    private PubDictionDao pubDictionDao;

    /**
     * 通过Id删除字典
     *
     * @param dictionId
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Long dictionId) throws CustomerException {
        try {
            int deleteByPrimaryKey = pubDictionDao.deleteByPrimaryKey(dictionId);
            log.info("删除字典成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除字典失败,异常信息:{}",e.getMessage());
            throw new CustomerException("删除字典失败");
        }
    }

    @Override
    public List<PubDiction> selectByType(String dictionType) {
        return pubDictionDao.selectByType(dictionType);
    }

    /**
     * 新增字典
     *
     * @param record
     * @return
     */
    @Override
    public int insertSelective(PubDiction record) throws CustomerException {
        try {
            record.setDictionId(IdUtils.nextId());
            int insertSelective = pubDictionDao.insertSelective(record);
            log.info("新增字典成功,受影响行数:{}",insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增字典失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增字典失败");
        }
    }

    /**
     * 通过Id查询字典
     *
     * @param dictionId
     * @return
     */
    @Override
    public PubDiction selectByPrimaryKey(Long dictionId) {
        return pubDictionDao.selectByPrimaryKey(dictionId);
    }

    /**
     * 更新字典
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(PubDictionVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = pubDictionDao.updateByPrimaryKeySelective(record);
            log.info("更新字典成功,受影响行数:{}",updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新字典成功,异常信息:{}",e.getMessage());
            throw new CustomerException("更新字典成功");
        }
    }

    /**
     * 查询所有字典
     * @return
     */
    @Override
    public List<PubDiction> queryDicList() {
        return pubDictionDao.queryDicList();
    }

    /**
     * 批量删除字典信息
     * @param dictionIds
     * @return
     * @throws CustomerException
     */
    @Override
    public int delDictionList(Long[] dictionIds) throws CustomerException {
        try {
            int delDictionList = pubDictionDao.delDictionList(dictionIds);
            log.info("批量删除字典信息成功,受影响行数:{}",delDictionList);
            return delDictionList;
        } catch (Exception e) {
            log.error("批量删除字典信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("批量删除字典信息失败");
        }
    }
}
