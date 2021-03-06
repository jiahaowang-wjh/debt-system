package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAssignmentNotice;
import com.smart.bracelet.model.vo.assets.BusAssignmentNoticeShow;
import com.smart.bracelet.model.vo.assets.BusAssignmentNoticeVo;

import java.text.ParseException;
import java.util.List;

public interface BusAssignmentNoticeService {

    int deleteByPrimaryKey(Long assignmentNoticeId) throws CustomerException;

    Long insertSelective(BusAssignmentNotice record) throws CustomerException;

    BusAssignmentNotice selectByPrimaryKey(Long assignmentNoticeId);

    int updateByPrimaryKeySelective(BusAssignmentNoticeVo record) throws CustomerException;

    List<BusAssignmentNotice> queryList();

    /**
     * 初始化资产债权转让通知书
     * @param relativePerId
     * @return
     */
    BusAssignmentNoticeShow initialize(Long relativePerId) throws ParseException;

    /**
     * 通过资产id查询资产债权转让通知书
     * @param propertId
     * @return
     */
    BusAssignmentNotice selectByPropertId(Long propertId);
}
