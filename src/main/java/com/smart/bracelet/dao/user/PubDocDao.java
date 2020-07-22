package com.smart.bracelet.dao.user;

import com.smart.bracelet.model.po.user.PubDoc;
import com.smart.bracelet.model.vo.user.PubDocVo;
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

    /**
     * 批量删除文档
     * @param docIds
     * @return
     */
    int delDocList(Long[] docIds);
}