package com.smart.bracelet.service.user.impl;

import com.smart.bracelet.dao.user.PubCompanyDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubArea;
import com.smart.bracelet.model.po.user.PubCompany;
import com.smart.bracelet.model.vo.user.PubCompanyVo;
import com.smart.bracelet.service.user.PubAreaService;
import com.smart.bracelet.service.user.PubCompanyService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class PubCompanyServiceImpl implements PubCompanyService {

    @Autowired
    private PubCompanyDao pubCompanyDao;

    @Autowired
    private PubAreaService pubAreaService;

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long companyId) throws CustomerException {
        try {
            int deleteByPrimaryKey = pubCompanyDao.deleteByPrimaryKey(companyId);
            log.info("删除公司信息成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除公司信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除公司信息失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int insertSelective(PubCompany record) throws CustomerException {
        try {
            if (record.getCompanyId() == null) {
                record.setCompanyId(IdUtils.nextId());
            }
            int insertSelective = pubCompanyDao.insertSelective(record);
            log.info("新增公司信息成功,受影响行数:{}", insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增公司信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增公司信息失败");
        }
    }

    @Override
    public PubCompany selectByPrimaryKey(Long companyId) {
        PubCompany pubCompany = pubCompanyDao.selectByPrimaryKey(companyId);
        pubCompany.setAreas(pubAreaService.selectByPrimaryKey(pubCompany.getAreaId()));
        return pubCompany;
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(PubCompanyVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = pubCompanyDao.updateByPrimaryKeySelective(record);
            log.info("更新公司信息成功,受影响行数:{}", updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新公司信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新公司信息失败");
        }
    }

    @Override
    public PubCompany selectByNameMax(String nameMax) {
        return pubCompanyDao.selectByNameMax(nameMax);
    }

    @Override
    public List<PubCompany> queryList() {
        return pubCompanyDao.queryList();
    }
}
