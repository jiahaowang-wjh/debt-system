package com.smart.bracelet.dao.user;

import com.smart.bracelet.model.po.user.PubDiction;
import com.smart.bracelet.model.vo.user.PubDictionVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 字典表
 */
@Repository
public interface PubDictionDao {

    /**
     * 通过Id删除字典
     * @param dictionId
     * @return
     */
    int deleteByPrimaryKey(Long dictionId);

    /**
     * 新增字典
     * @param record
     * @return
     */
    int insertSelective(PubDiction record);

    /**
     * 通过Id查询字典
     * @param dictionId
     * @return
     */
    PubDiction selectByPrimaryKey(Long dictionId);

    /**
     * 通过类型查询字典
     * @param dictionType
     * @return
     */
    List<PubDiction> selectByType(String dictionType);

    /**
     * 更新字典
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PubDictionVo record);

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
    int delDictionList(Long[] dictionIds);

}