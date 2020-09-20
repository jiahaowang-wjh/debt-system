package com.smart.bracelet.service.user.impl;

import com.smart.bracelet.dao.user.PubCompanyDao;
import com.smart.bracelet.dao.user.PubDocDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubCompany;
import com.smart.bracelet.model.po.user.PubDoc;
import com.smart.bracelet.model.vo.user.PubDocVo;
import com.smart.bracelet.service.user.PubDocService;
import com.smart.bracelet.utils.IdUtils;
import com.smart.bracelet.utils.RepNoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class PubDocServiceImpl implements PubDocService {

    @Autowired
    private PubDocDao pubDocDao;

    @Autowired
    private PubCompanyDao pubCompanyDao;

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long docId) throws CustomerException {
        try {
            int deleteByPrimaryKey = pubDocDao.deleteByPrimaryKey(docId);
            log.info("删除文档表成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除文档表失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除文档表失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int insertSelective(PubDoc record) throws CustomerException {
        try {
            PubCompany pubCompany = pubCompanyDao.selectByPrimaryKey(record.getComId());
            record.setDocId(IdUtils.nextId());
            String s = pubDocDao.selectNo();
            String ht = RepNoUtils.createRepNo(pubCompany.getCompanyNameMax(), pubCompany.getCompanyName(), s);
            record.setContract(ht);
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
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(PubDocVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = pubDocDao.updateByPrimaryKeySelective(record);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            throw new CustomerException("更新文档失败");
        }
    }

    /**
     * 批量删除文档
     *
     * @param docIds
     * @return
     */
    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int delDocList(Long[] docIds) throws CustomerException {
        try {
            int delDocList = pubDocDao.delDocList(docIds);
            log.info("批量删除文档成功,受影响行数:{}", delDocList);
            return delDocList;
        } catch (Exception e) {
            log.error("批量删除文档失败,异常信息:{}", e.getMessage());
            throw new CustomerException("批量删除文档失败");
        }
    }

    /**
     * 查询所有文档
     *
     * @return
     */
    @Override
    public List<PubDoc> queryDoc() {
        return pubDocDao.queryDoc();
    }
}
