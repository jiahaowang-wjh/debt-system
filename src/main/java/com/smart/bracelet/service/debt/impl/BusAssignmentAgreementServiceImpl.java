package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.BusAssignmentAgreementDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusAssignmentAgreement;
import com.smart.bracelet.model.vo.debt.BusAssignmentAgreementVo;
import com.smart.bracelet.service.debt.BusAssignmentAgreementService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BusAssignmentAgreementServiceImpl implements BusAssignmentAgreementService {

    @Autowired
    private BusAssignmentAgreementDao busAssignmentAgreementDao;

    @Override
    public int deleteByPrimaryKey(Long assignmentAgreementId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busAssignmentAgreementDao.deleteByPrimaryKey(assignmentAgreementId);
            log.info("删除资产债券转让协议成功");
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除资产债券转让协议失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除资产债券转让协议失败");
        }
    }

    @Override
    public int insertSelective(BusAssignmentAgreement record) throws CustomerException {
        try {
            record.setAssignmentAgreementId(IdUtils.nextId());
            int insertSelective = busAssignmentAgreementDao.insertSelective(record);
            log.info("新增资产债券转让协议成功");
            return insertSelective;
        } catch (Exception e) {
            log.error("新增资产债券转让协议失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增资产债券转让协议失败");
        }
    }

    @Override
    public BusAssignmentAgreement selectByPrimaryKey(Long assignmentAgreementId) {
        return busAssignmentAgreementDao.selectByPrimaryKey(assignmentAgreementId);
    }

    @Override
    public int updateByPrimaryKeySelective(BusAssignmentAgreementVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = busAssignmentAgreementDao.updateByPrimaryKeySelective(record);
            log.info("更新资产债券转让协议成功");
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新资产债券转让协议失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新资产债券转让协议失败");
        }
    }

    @Override
    public List<BusAssignmentAgreement> queryList() {
        return busAssignmentAgreementDao.queryList();
    }
}
