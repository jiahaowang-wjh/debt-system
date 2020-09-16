package com.smart.bracelet.service.user.impl;

import com.smart.bracelet.dao.user.PubPersonDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubPerson;
import com.smart.bracelet.model.po.user.PubUser;
import com.smart.bracelet.model.vo.user.PubPersonVo;
import com.smart.bracelet.service.user.PubPersonService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 人员信息
 */
@Service
@Slf4j
public class PubPersonServiceImpl implements PubPersonService {

    @Autowired
    private PubPersonDao pubPerson;

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long personId) throws CustomerException {
        try {
            int deleteByPrimaryKey = pubPerson.deleteByPrimaryKey(personId);
            log.info("人员信息删除成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("人员信息删除失败,异常信息:{}", e.getMessage());
            throw new CustomerException("人员信息删除失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int insertSelective(PubPerson record) throws CustomerException {
        try {
            record.setPersonId(IdUtils.nextId());
            int insertSelective = pubPerson.insertSelective(record);
            log.info("人员信息添加成功,受影响行数:{}", insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("人员信息添加失败,异常信息:{}", e.getMessage());
            throw new CustomerException("人员信息添加失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public PubPerson selectByPrimaryKey(Long personId) {
        return pubPerson.selectByPrimaryKey(personId);
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(PubPersonVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = pubPerson.updateByPrimaryKeySelective(record);
            log.info("人员信息更新成功,受影响行数:{}", updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("人员信息更新失败,异常信息:{}", e.getMessage());
            throw new CustomerException("人员信息更新失败");
        }
    }

    @Override
    public List<PubPerson> selectByType(String personType) {
        return pubPerson.selectByType(personType);
    }
}
