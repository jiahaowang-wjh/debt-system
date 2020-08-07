package com.smart.bracelet.dao.assets;

import com.smart.bracelet.model.po.assets.BusAssignmentNotice;
import com.smart.bracelet.model.vo.assets.BusAssignmentNoticeVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusAssignmentNoticeDao {

    int deleteByPrimaryKey(Long assignmentNoticeId);

    int insertSelective(BusAssignmentNotice record);

    BusAssignmentNotice selectByPrimaryKey(Long assignmentNoticeId);

    int updateByPrimaryKeySelective(BusAssignmentNoticeVo record);

    List<BusAssignmentNotice> queryList();
}