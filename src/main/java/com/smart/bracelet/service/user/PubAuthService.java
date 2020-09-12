package com.smart.bracelet.service.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubAuth;
import com.smart.bracelet.model.vo.user.PubAuthVo;

import java.util.List;

public interface PubAuthService {
    /**
     * 删除权限信息
     * @param authId
     * @return
     */
    int deleteByPrimaryKey(Long authId) throws CustomerException;

    /**
     * 添加权限信息
     * @param record
     * @return
     */
    int insertSelective(PubAuth record) throws CustomerException;

    /**
     * 通过ID查询权限信息
     * @param authId
     * @return
     */
    PubAuth selectByPrimaryKey(Long authId);

    /**
     * 修改权限信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PubAuthVo record) throws CustomerException;


    /**
     * 权限信息查询分页
     * @return
     */
    List<PubAuth> selectPageAuth();
    /**
     * 用户权限
     */
    List<PubAuth> selectUserAuth();

    /**
     * 债务权限
     */
    List<PubAuth> selectDebtAuth();

    /**
     * 资产权限
     */
    List<PubAuth> selectAssetsAuth();
}
