package com.smart.bracelet.service.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubDoc;
import com.smart.bracelet.model.vo.user.PubDocVo;

public interface PubDocService {
    int deleteByPrimaryKey(Long docId) throws CustomerException;

    int insertSelective(PubDoc record) throws CustomerException;

    PubDoc selectByPrimaryKey(Long docId);

    int updateByPrimaryKeySelective(PubDocVo record) throws CustomerException;
    /**
     * 批量删除文档
     * @param docIds
     * @return
     */
    int delDocList(Long[] docIds) throws CustomerException;
}
