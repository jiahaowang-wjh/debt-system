package com.smart.bracelet.service.user.impl;

import com.smart.bracelet.dao.user.PubExpDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubExp;
import com.smart.bracelet.model.vo.user.PubExpVo;
import com.smart.bracelet.service.user.PubExpService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class PubExpServiceImpl implements PubExpService {

    @Autowired
    private PubExpDao pubExpDao;

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long expId) throws CustomerException {
        try {
            int deleteByPrimaryKey = pubExpDao.deleteByPrimaryKey(expId);
            log.info("删除公式表信息成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除公示表信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除公示表信息失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int insertSelective(PubExp record) throws CustomerException {
        try {
            record.setExpId(IdUtils.nextId());
            int insertSelective = pubExpDao.insertSelective(record);
            log.info("新增公式表信息成功,受影响行数:{}", insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增公式表信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增公式表信息失败");
        }
    }

    @Override
    public PubExp selectByPrimaryKey(Long expId) {
        return pubExpDao.selectByPrimaryKey(expId);
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(PubExpVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = pubExpDao.updateByPrimaryKeySelective(record);
            log.info("更新公式信息成功,受影响行数:{}", updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新公式信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新公式信息失败");
        }
    }

    @Override
    public List<PubExp> queryExpList() {
        return pubExpDao.queryExpList();
    }

    /**
     * 批量删除公式信息
     *
     * @param expIds
     * @return
     * @throws CustomerException
     */
    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int delExpList(Long[] expIds) throws CustomerException {
        try {
            int delExpList = pubExpDao.delExpList(expIds);
            log.info("批量删除公式信息成功,受影响行数:{}", delExpList);
            return delExpList;
        } catch (Exception e) {
            log.error("批量删除公式信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("批量删除公式信息失败");
        }
    }
}
