package com.smart.bracelet.service.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubDiction;
import com.smart.bracelet.model.vo.user.PubDictionVo;

import java.util.List;

public interface PubDictionService {
    /**
     * 通过Id删除字典
     * @param dictionId
     * @return
     */
    int deleteByPrimaryKey(Long dictionId) throws CustomerException;


    /**
     * 通过类型查询字典
     * @param dictionType
     * @return
     */
    List<PubDiction> selectByType(String dictionType);

    /**
     * 新增字典
     * @param record
     * @return
     */
    int insertSelective(PubDiction record) throws CustomerException;

    /**
     * 通过Id查询字典
     * @param dictionId
     * @return
     */
    PubDiction selectByPrimaryKey(Long dictionId);

    /**
     * 更新字典
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PubDictionVo record) throws CustomerException;

    /**
     * 查询所有字典
     * @return
     */
    List<PubDiction> queryDicList();

    /**
     * 批量删除字典
     * @param dictionIds
     * @return
     */
    int delDictionList(Long[] dictionIds) throws CustomerException;

    /**
     * 查询代理销售合同商品
     */
    List<PubDiction> selectCommodity();


    /**
     * 查询代理销售合同产地
     */
    List<PubDiction> selectPlace();

    /**
     * 查询代理销售合同规格
     */
    List<PubDiction> selectNorm();

    /**
     * 查询代理销售合同计量单位
     */
    List<PubDiction> selectMeasure();

    /**
     * 查询代理销售合同计量包装
     */
    List<PubDiction> selectPackage();
}
