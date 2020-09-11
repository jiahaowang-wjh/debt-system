package com.smart.bracelet.dao.assets;

import com.smart.bracelet.model.po.assets.BusAssignmentNotice;
import com.smart.bracelet.model.vo.assets.BusAssignmentNoticeShow;
import com.smart.bracelet.model.vo.assets.BusAssignmentNoticeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusAssignmentNoticeDao {

    int deleteByPrimaryKey(Long assignmentNoticeId);

    int insertSelective(BusAssignmentNotice record);

    BusAssignmentNotice selectByPrimaryKey(Long assignmentNoticeId);

    int updateByPrimaryKeySelective(BusAssignmentNoticeVo record);

    List<BusAssignmentNotice> queryList();

    /**
     * 初始化资产债权转让通知书
     * @param relativePerId
     * @return
     */
    BusAssignmentNoticeShow initialize(Long relativePerId);

    /**
     * 通过资产id查询资产债权转让通知书
     * @param propertId
     * @return
     */
    BusAssignmentNotice selectByPropertId(Long propertId);

    String selectNo();
}