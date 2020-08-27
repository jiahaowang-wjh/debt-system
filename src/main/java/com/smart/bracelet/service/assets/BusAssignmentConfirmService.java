package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAssignmentConfirm;
import com.smart.bracelet.model.vo.assets.BusAssignmentConfirmShow;
import com.smart.bracelet.model.vo.assets.BusAssignmentConfirmVo;

import java.util.List;

public interface BusAssignmentConfirmService {
    int deleteByPrimaryKey(Long posseConfirmtId) throws CustomerException;

    int insertSelective(BusAssignmentConfirm record) throws CustomerException;

    BusAssignmentConfirm selectByPrimaryKey(Long posseConfirmtId);

    int updateByPrimaryKeySelective(BusAssignmentConfirmVo record) throws CustomerException;

    List<BusAssignmentConfirm> queryList();

    /**
     * 初始化资产债权转让确认页面
     * @return
     */
    BusAssignmentConfirmShow initialize(Long reportId);
}
