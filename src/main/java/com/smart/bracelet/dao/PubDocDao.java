package com.smart.bracelet.dao;

import com.smart.bracelet.model.po.PubDoc;
import com.smart.bracelet.model.vo.PubDocVo;
import org.springframework.stereotype.Repository;

/**
 * 文档表
 */
@Repository
public interface PubDocDao {

    int deleteByPrimaryKey(Long docId);

    int insertSelective(PubDoc record);

    PubDoc selectByPrimaryKey(Long docId);

    int updateByPrimaryKeySelective(PubDocVo record);

}