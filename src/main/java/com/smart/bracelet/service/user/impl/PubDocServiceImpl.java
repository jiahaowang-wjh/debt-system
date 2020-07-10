package com.smart.bracelet.service.user.impl;

import com.smart.bracelet.dao.user.PubDocDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubDoc;
import com.smart.bracelet.model.vo.user.PubDocVo;
import com.smart.bracelet.service.user.PubDocService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PubDocServiceImpl implements PubDocService {

    @Autowired
    private PubDocDao pubDocDao;

    @Override
    public int deleteByPrimaryKey(Long docId) throws CustomerException {
        try {
            int deleteByPrimaryKey = pubDocDao.deleteByPrimaryKey(docId);
            log.info("删除文档表成功,受影响行数:{}",deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除文档表失败,异常信息:{}",e.getMessage());
            throw new CustomerException("删除文档表失败");
        }
    }

    @Override
    public int insertSelective(PubDoc record) throws CustomerException {
        try {
            record.setDocId(IdUtils.nextId());
            int insertSelective = pubDocDao.insertSelective(record);
            return insertSelective;
        } catch (Exception e) {
            throw new CustomerException("新增文档失败");
        }
    }

    @Override
    public PubDoc selectByPrimaryKey(Long docId) {
        return pubDocDao.selectByPrimaryKey(docId);
    }

    @Override
    public int updateByPrimaryKeySelective(PubDocVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = pubDocDao.updateByPrimaryKeySelective(record);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            throw new CustomerException("更新文档失败");
        }
    }
}
