package com.smart.bracelet.service.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubMenu;
import com.smart.bracelet.model.vo.user.PubMenuVo;

import java.util.List;

public interface PubMenuService {

    int deleteByPrimaryKey(Long menuId) throws CustomerException;

    int insertSelective(PubMenu record) throws CustomerException;

    PubMenu selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(PubMenuVo record) throws CustomerException;

    List<PubMenu> queryMenuList();

}
