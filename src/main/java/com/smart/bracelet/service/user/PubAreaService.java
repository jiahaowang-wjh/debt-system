package com.smart.bracelet.service.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubArea;
import com.smart.bracelet.model.vo.user.PubAreaVo;

import java.util.List;

public interface PubAreaService {

    int deleteByPrimaryKey(Long areaId) throws CustomerException;

    int insertSelective(PubArea record) throws CustomerException;

    /**
     * 通过区域ID获取区县市省信息
     */
    String selectByPrimaryKey(Long areaId);

    int updateByPrimaryKeySelective(PubAreaVo record) throws CustomerException;


    List<PubArea> selectByArName(String name);



    /**
     * 获取省级数据（一级）
     * @return
     */
    List<PubArea> queryParent();


    /**
     * 获取市县级数据（二级级）
     * @return
     */
    List<PubArea> querySubset(Long parentId);

}
