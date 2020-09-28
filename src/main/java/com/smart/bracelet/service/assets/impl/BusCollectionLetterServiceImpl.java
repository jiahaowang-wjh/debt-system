package com.smart.bracelet.service.assets.impl;

import com.smart.bracelet.dao.assets.BusCollectionLetterDao;
import com.smart.bracelet.dao.user.PubCompanyDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusCollectionLetter;
import com.smart.bracelet.model.po.user.PubCompany;
import com.smart.bracelet.model.vo.assets.BusCollectionLetterShow;
import com.smart.bracelet.model.vo.assets.BusCollectionLetterVo;
import com.smart.bracelet.service.assets.BusCollectionLetterService;
import com.smart.bracelet.utils.ConvertUpMoney;
import com.smart.bracelet.utils.IdUtils;
import com.smart.bracelet.utils.RepNoUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BusCollectionLetterServiceImpl implements BusCollectionLetterService {

    @Autowired
    private BusCollectionLetterDao busCollectionLetterDao;

    @Autowired
    private PubCompanyDao pubCompanyDao;

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long collectionLettertId) throws CustomerException {
        try {
            int deleteByPrimaryKey = busCollectionLetterDao.deleteByPrimaryKey(collectionLettertId);
            log.info("删除资产催款函成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除资产催款函失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除资产催款函失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int insertSelective(BusCollectionLetter record) throws CustomerException {
        try {
            record.setCollectionLettertId(IdUtils.nextId());
            int deleteByPrimaryKey = busCollectionLetterDao.insertSelective(record);
            log.info("新增资产催款函成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("新增资产催款函失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增资产催款函失败");
        }
    }

    @Override
    public BusCollectionLetter selectByPrimaryKey(Long collectionLettertId) {
        return busCollectionLetterDao.selectByPrimaryKey(collectionLettertId);
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(BusCollectionLetterVo record) throws CustomerException {
        try {
            int deleteByPrimaryKey = busCollectionLetterDao.updateByPrimaryKeySelective(record);
            log.info("更新资产催款函成功,受影响行数:{}", deleteByPrimaryKey);
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("更新资产催款函失败,异常信息:{}", e.getMessage());
            throw new CustomerException("更新资产催款函失败");
        }
    }

    @Override
    public List<BusCollectionLetter> queryList() {
        return busCollectionLetterDao.queryList();
    }

    /**
     * 催款函页面初始化
     *
     * @param propertId
     * @return
     */
    @Override
    public BusCollectionLetterShow initialize(Long propertId,Long comId) throws ParseException {
        BusCollectionLetterShow initialize = busCollectionLetterDao.initialize(propertId);
        if(StringUtils.isEmpty(initialize.getCollectionLettertNo())){
            String selectNo = busCollectionLetterDao.selectNo();
            PubCompany pubCompany = pubCompanyDao.selectByPrimaryKey(comId);
            initialize.setCollectionLettertNo(RepNoUtils.createRepNo("ZC",pubCompany.getCompanyNameMax(),selectNo));
            initialize.setContractDate(new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
        }
        initialize.setMoneyMax(ConvertUpMoney.toChinese(initialize.getAmountThis().toString()));
        return initialize;
    }

    @Override
    public BusCollectionLetter selectByPropertId(Long propertId) {
        return busCollectionLetterDao.selectByPropertId(propertId);
    }


}
