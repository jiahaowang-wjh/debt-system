package com.smart.bracelet.service.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubPerson;
import com.smart.bracelet.model.vo.user.PubPersonVo;

public interface PubPersonService {
    /**
     * 通过ID删除人员信息
     * @param personId
     * @return
     */
    int deleteByPrimaryKey(Long personId) throws CustomerException;

    /**
     * 新增人员信息
     * @param record
     * @return
     */
    int insertSelective(PubPerson record) throws CustomerException;

    /**
     * 通过Id查询人员
     * @param personId
     * @return
     */
    PubPerson selectByPrimaryKey(Long personId);

    /**
     * 更新人员信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PubPersonVo record) throws CustomerException;

}
