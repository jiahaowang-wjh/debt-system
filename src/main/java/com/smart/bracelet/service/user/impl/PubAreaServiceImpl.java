package com.smart.bracelet.service.user.impl;

import com.smart.bracelet.dao.user.PubAreaDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubArea;
import com.smart.bracelet.model.vo.user.PubAreaVo;
import com.smart.bracelet.service.user.PubAreaService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PubAreaServiceImpl implements PubAreaService {

    @Autowired
    private PubAreaDao pubAreaDao;

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long personId) throws CustomerException {
        try {
            int deleteByPrimaryKey = pubAreaDao.deleteByPrimaryKey(personId);
            log.info("删除区域信息成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除区域信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除区域信息失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int insertSelective(PubArea pubArea) throws CustomerException {
        try {
            pubArea.setAreaId(IdUtils.nextId());
            int insertSelective = pubAreaDao.insertSelective(pubArea);
            log.info("新增区域信息成功,受影响行数:{}", insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增区域信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增区域信息失败");
        }
    }

    @Override
    public String selectByPrimaryKey(Long areaId) {
        String arName;
        PubArea pubArea = pubAreaDao.selectByPrimaryKey(areaId);
        arName = pubArea.getAreaName();
        if (pubArea.getParentId() != 0) {
            PubArea pubArea1 = pubAreaDao.selectByPrimaryKey(pubArea.getParentId());
            arName = pubArea1.getAreaName() + "," + arName;
            if (pubArea1.getParentId() != 0) {
                PubArea pubArea2 = pubAreaDao.selectByPrimaryKey(pubArea1.getParentId());
                arName = pubArea2.getAreaName() + "," + arName;
            }
        }
        return arName;
    }


    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(PubAreaVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = pubAreaDao.updateByPrimaryKeySelective(record);
            log.info("更新区域信息成功,受影响行数:{}", updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("更新区域信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新区域信息失败");
        }
    }

    @Override
    public List<PubArea> selectByArName(String name) {
        return pubAreaDao.selectByArName(name);
    }

    @Override
    public List<PubArea> queryParent() {
        return pubAreaDao.queryParent();
    }

    @Override
    public List<PubArea> querySubset(Long parentId) {
        return pubAreaDao.querySubset(parentId);
    }

}
