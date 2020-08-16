package com.smart.bracelet.dao.assets;

import com.smart.bracelet.model.po.assets.BusAssignmentConfirm;
import com.smart.bracelet.model.vo.assets.BusAssignmentConfirmVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusAssignmentConfirmDao {
    int deleteByPrimaryKey(Long posseConfirmtId);

    int insertSelective(BusAssignmentConfirm record);

    BusAssignmentConfirm selectByPrimaryKey(Long posseConfirmtId);

    int updateByPrimaryKeySelective(BusAssignmentConfirmVo record);

    List<BusAssignmentConfirm> queryList();

    /**
     * 查询最后一条编号记录
     * @return
     */
    String selectNo();
}