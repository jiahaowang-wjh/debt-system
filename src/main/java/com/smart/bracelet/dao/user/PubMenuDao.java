package com.smart.bracelet.dao.user;

import com.smart.bracelet.model.po.user.PubMenu;
import com.smart.bracelet.model.vo.user.PubMenuVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PubMenuDao {

    int deleteByPrimaryKey(Long menuId);

    int insertSelective(PubMenu record);

    PubMenu selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(PubMenuVo record);

    List<PubMenu> queryMenuList();


}