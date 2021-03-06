package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAssignmentConfirm;
import com.smart.bracelet.model.vo.assets.BusAssignmentConfirmShow;
import com.smart.bracelet.model.vo.assets.BusAssignmentConfirmVo;

import java.text.ParseException;
import java.util.List;

public interface BusAssignmentConfirmService {
    int deleteByPrimaryKey(Long posseConfirmtId) throws CustomerException;

    Long insertSelective(BusAssignmentConfirm record) throws CustomerException;

    BusAssignmentConfirm selectByPrimaryKey(Long posseConfirmtId);

    int updateByPrimaryKeySelective(BusAssignmentConfirmVo record) throws CustomerException;

    List<BusAssignmentConfirm> queryList();

    /**
     * 初始化资产债权转让确认页面
     * @return
     */
    BusAssignmentConfirmShow initialize(Long relativePerId) throws ParseException;

    /**
     * 通过资产ID查询资产债权转让确认
     * @param propertId
     * @return
     */
    BusAssignmentConfirm selectByPropertId(Long propertId);

}
