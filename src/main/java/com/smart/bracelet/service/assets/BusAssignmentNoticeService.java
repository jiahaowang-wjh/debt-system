package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusAssignmentNotice;
import com.smart.bracelet.model.vo.assets.BusAssignmentNoticeVo;

import java.util.List;

public interface BusAssignmentNoticeService {

    int deleteByPrimaryKey(Long assignmentNoticeId) throws CustomerException;

    int insertSelective(BusAssignmentNotice record) throws CustomerException;

    BusAssignmentNotice selectByPrimaryKey(Long assignmentNoticeId);

    int updateByPrimaryKeySelective(BusAssignmentNoticeVo record) throws CustomerException;

    List<BusAssignmentNotice> queryList();

}
