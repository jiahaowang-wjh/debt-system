package com.smart.bracelet.dao.user;

import com.smart.bracelet.model.po.user.PubArea;
import com.smart.bracelet.model.vo.user.PubAreaVo;
import org.springframework.stereotype.Repository;

@Repository
public interface PubAreaDao {

    int deleteByPrimaryKey(Long areaId);

    int insertSelective(PubArea record);

    PubArea selectByPrimaryKey(Long areaId);

    int updateByPrimaryKeySelective(PubAreaVo record);

}