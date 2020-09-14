package com.smart.bracelet.service.user.impl;

import com.smart.bracelet.dao.user.PubAuthDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubAuth;
import com.smart.bracelet.model.vo.user.PubAuthVo;
import com.smart.bracelet.service.user.PubAuthService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PubAuthServiceImpl implements PubAuthService {

    @Autowired
    private PubAuthDao pubAuthDao;

    /**
     * 删除权限信息
     * @param authId
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Long authId) throws CustomerException {
        try {
            int deleteByPrimaryKey = pubAuthDao.deleteByPrimaryKey(authId);
            log.info("删除权限信息成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除权限信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("删除权限信息失败");
        }
    }

    /**
     * 新增权限信息
     * @param record
     * @return
     */
    @Override
    public int insertSelective(PubAuth record) throws CustomerException {
        try {
            record.setAuthId(IdUtils.nextId());
            int insertSelective = pubAuthDao.insertSelective(record);
            log.info("新增权限信息成功,受影响行数:{}",insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增权限信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增权限信息失败");
        }
    }

    /**
     * 通过ID查询权限信息
     * @param authId
     * @return
     */
    @Override
    public PubAuth selectByPrimaryKey(Long authId) {
        return pubAuthDao.selectByPrimaryKey(authId);
    }

    /**
     * 修改权限信息
     * @param record
     * @return
     * @throws CustomerException
     */
    @Override
    public int updateByPrimaryKeySelective(PubAuthVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = pubAuthDao.updateByPrimaryKeySelective(record);
            log.info("修改权限信息成功,受影响行数:{}",updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("修改权限信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("修改权限信息失败");
        }
    }

    @Override
    public List<PubAuth> selectPageAuth() {
        return pubAuthDao.selectPageAuth();
    }

    @Override
    public List<PubAuth> selectUserAuth() {
        return pubAuthDao.selectUserAuth();
    }

    @Override
    public List<PubAuth> selectDebtAuth() {
        return pubAuthDao.selectDebtAuth();
    }

    @Override
    public List<PubAuth> selectAssetsAuth() {
        return pubAuthDao.selectAssetsAuth();
    }


}
