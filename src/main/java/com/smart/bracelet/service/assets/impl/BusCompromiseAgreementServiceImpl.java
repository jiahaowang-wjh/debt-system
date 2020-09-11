package com.smart.bracelet.service.assets.impl;

import com.smart.bracelet.dao.assets.BusCompromiseAgreementDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusCompromiseAgreement;
import com.smart.bracelet.model.po.assets.Manner1;
import com.smart.bracelet.model.po.assets.Manner1AndManner2;
import com.smart.bracelet.model.po.assets.Manner2;
import com.smart.bracelet.model.vo.assets.BusCompromiseAgreementShow;
import com.smart.bracelet.model.vo.assets.Manner1Vo;
import com.smart.bracelet.model.vo.assets.Manner2Vo;
import com.smart.bracelet.service.assets.BusCompromiseAgreementService;
import com.smart.bracelet.utils.IdUtils;
import com.smart.bracelet.utils.RepNoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BusCompromiseAgreementServiceImpl implements BusCompromiseAgreementService {

    @Autowired
    private BusCompromiseAgreementDao busCompromiseAgreementDao;

    @Override
    public int deleteByPrimaryKey(Long compromiseAgreementId) throws CustomerException {

        int deleteByPrimaryKey = 0;
        try {
            deleteByPrimaryKey = busCompromiseAgreementDao.deleteByPrimaryKey(compromiseAgreementId);
            log.info("删除资产和解协议成功,受影响行数:{}",deleteByPrimaryKey);
        } catch (Exception e) {
            log.error("删除资产和解协议失败,异常信息:{}",e.getMessage());
            throw new CustomerException("删除资产和解协议失败");
        }
        return deleteByPrimaryKey;
    }
    /**
     * 全款
     * @param manner1Vo
     * @return
     * @throws CustomerException
     */
    @Override
    public int insertSelectiveManner1(Manner1 manner1Vo) throws CustomerException {
        String selectNo = busCompromiseAgreementDao.selectNo();
        String repNo = RepNoUtils.createRepNo("ZCGS", "HJ", selectNo);
        try {
            BusCompromiseAgreement busCompromiseAgreement = new BusCompromiseAgreement();
            busCompromiseAgreement.setCompromiseAgreementId(IdUtils.nextId());
            busCompromiseAgreement.setCompromiseAgreementNo(repNo);
            busCompromiseAgreement.setPropertId(manner1Vo.getPropertId());
            busCompromiseAgreement.setPartybMode(manner1Vo.getPartybMode());
            busCompromiseAgreement.setData1(manner1Vo.getCash());
            busCompromiseAgreement.setPartyaSubrogation(manner1Vo.getPartyaSubrogation());
            busCompromiseAgreement.setPartybSubrogation(manner1Vo.getPartybSubrogation());
            busCompromiseAgreement.setPartyaDate(manner1Vo.getPartyaDate());
            busCompromiseAgreement.setPartyaSeal(manner1Vo.getPartyaSeal());
            busCompromiseAgreement.setPartybSeal(manner1Vo.getPartybSeal());
            busCompromiseAgreement.setPartybDate(manner1Vo.getPartybDate());
            int insertSelective = busCompromiseAgreementDao.insertSelective(busCompromiseAgreement);
            log.info("新增资产和解协议全款成功受影响行数:{}",insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增资产和解协议全款失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增资产和解协议全款失败");
        }
    }

    /**
     * 分期
     * @param manner2Vo
     * @return
     * @throws CustomerException
     */
    @Override
    public int insertSelectiveManner2(Manner2 manner2Vo) throws CustomerException {
        String selectNo = busCompromiseAgreementDao.selectNo();
        String repNo = RepNoUtils.createRepNo("ZCGS", "HJ", selectNo);
        try {
            BusCompromiseAgreement busCompromiseAgreement = new BusCompromiseAgreement();
            busCompromiseAgreement.setCompromiseAgreementId(IdUtils.nextId());
            busCompromiseAgreement.setCompromiseAgreementNo(repNo);
            busCompromiseAgreement.setPropertId(manner2Vo.getPropertId());
            busCompromiseAgreement.setPartybMode(manner2Vo.getPartybMode());
            busCompromiseAgreement.setData1(manner2Vo.getMoney());
            busCompromiseAgreement.setData2(manner2Vo.getStagingNumber());
            busCompromiseAgreement.setData3(manner2Vo.getDays());
            busCompromiseAgreement.setPartyaSubrogation(manner2Vo.getPartyaSubrogation());
            busCompromiseAgreement.setPartyaDate(manner2Vo.getPartyaDate());
            busCompromiseAgreement.setPartyaSeal(manner2Vo.getPartyaSeal());
            busCompromiseAgreement.setPartybSeal(manner2Vo.getPartybSeal());
            busCompromiseAgreement.setPartybSubrogation(manner2Vo.getPartybSubrogation());
            busCompromiseAgreement.setPartybDate(manner2Vo.getPartybDate());
            int insertSelective = busCompromiseAgreementDao.insertSelective(busCompromiseAgreement);
            log.info("新增资产和解协议全款成功受影响行数:{}",insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("新增资产和解协议全款失败,异常信息:{}",e.getMessage());
            throw new CustomerException("新增资产和解协议全款失败");
        }
    }


    @Override
    public Manner1AndManner2 selectByPrimaryKey(Long compromiseAgreementId) throws CustomerException {
        try {
            Manner1AndManner2 manner1VoAndManner2Vo = new Manner1AndManner2();
            BusCompromiseAgreement busCompromiseAgreement = busCompromiseAgreementDao.selectByPrimaryKey(compromiseAgreementId);
            //判断是分期还款还是全款
            if(busCompromiseAgreement.getData2()!=null&&busCompromiseAgreement.getData3()!=null){
                manner1VoAndManner2Vo.setCompromiseAgreementId(busCompromiseAgreement.getCompromiseAgreementId());
                manner1VoAndManner2Vo.setPropertId(busCompromiseAgreement.getPropertId());
                manner1VoAndManner2Vo.setPartybMode(busCompromiseAgreement.getPartybMode());
                manner1VoAndManner2Vo.setStagingNumber(busCompromiseAgreement.getData2());
                manner1VoAndManner2Vo.setMoney(busCompromiseAgreement.getData1());
                manner1VoAndManner2Vo.setDays(busCompromiseAgreement.getData3());
                manner1VoAndManner2Vo.setPartyaSubrogation(busCompromiseAgreement.getPartyaSubrogation());
                manner1VoAndManner2Vo.setPartyaDate(busCompromiseAgreement.getPartyaDate());
                manner1VoAndManner2Vo.setPartyaSeal(busCompromiseAgreement.getPartyaSeal());
                manner1VoAndManner2Vo.setPartybSeal(busCompromiseAgreement.getPartybSeal());
                manner1VoAndManner2Vo.setPartybSubrogation(busCompromiseAgreement.getPartybSubrogation());
                manner1VoAndManner2Vo.setPartybDate(busCompromiseAgreement.getPartybDate());
                manner1VoAndManner2Vo.setType("2");
            }else{
                manner1VoAndManner2Vo.setCompromiseAgreementId(busCompromiseAgreement.getCompromiseAgreementId());
                manner1VoAndManner2Vo.setPropertId(busCompromiseAgreement.getPropertId());
                manner1VoAndManner2Vo.setPartybMode(busCompromiseAgreement.getPartybMode());
                manner1VoAndManner2Vo.setCash(busCompromiseAgreement.getData1());
                manner1VoAndManner2Vo.setPartyaSubrogation(busCompromiseAgreement.getPartyaSubrogation());
                manner1VoAndManner2Vo.setPartyaDate(busCompromiseAgreement.getPartyaDate());
                manner1VoAndManner2Vo.setPartyaSeal(busCompromiseAgreement.getPartyaSeal());
                manner1VoAndManner2Vo.setPartybSeal(busCompromiseAgreement.getPartybSeal());
                manner1VoAndManner2Vo.setPartybSubrogation(busCompromiseAgreement.getPartybSubrogation());
                manner1VoAndManner2Vo.setPartybDate(busCompromiseAgreement.getPartybDate());
                manner1VoAndManner2Vo.setType("1");
            }
            return manner1VoAndManner2Vo;
        } catch (Exception e) {
            log.error("异常信息:{}",e.getMessage());
            throw new CustomerException("查询异常");
        }
    }

    @Override
    public int updateByPrimaryKeySelectiveManner1Vo(Manner1Vo manner1Vo) throws CustomerException {
        try {
            BusCompromiseAgreement busCompromiseAgreement = new BusCompromiseAgreement();
            busCompromiseAgreement.setCompromiseAgreementId(manner1Vo.getCompromiseAgreementId());
            busCompromiseAgreement.setPropertId(manner1Vo.getPropertId());
            busCompromiseAgreement.setPartybMode(manner1Vo.getPartybMode());
            busCompromiseAgreement.setData1(manner1Vo.getCash());
            busCompromiseAgreement.setPartyaSubrogation(manner1Vo.getPartyaSubrogation());
            busCompromiseAgreement.setPartyaDate(manner1Vo.getPartyaDate());
            busCompromiseAgreement.setPartyaSeal(manner1Vo.getPartyaSeal());
            busCompromiseAgreement.setPartybSeal(manner1Vo.getPartybSeal());
            busCompromiseAgreement.setPartybDate(manner1Vo.getPartybDate());
            int insertSelective = busCompromiseAgreementDao.updateByPrimaryKeySelective(busCompromiseAgreement);
            log.info("更新资产和解协议全款成功受影响行数:{}",insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("更新资产和解协议全款失败,异常信息:{}",e.getMessage());
            throw new CustomerException("更新资产和解协议全款失败");
        }
    }

    @Override
    public int updateByPrimaryKeySelectiveManner2Vo(Manner2Vo manner2Vo) throws CustomerException {
        try {
            BusCompromiseAgreement busCompromiseAgreement = new BusCompromiseAgreement();
            busCompromiseAgreement.setCompromiseAgreementId(manner2Vo.getCompromiseAgreementId());
            busCompromiseAgreement.setPropertId(manner2Vo.getPropertId());
            busCompromiseAgreement.setPartybMode(manner2Vo.getPartybMode());
            busCompromiseAgreement.setData1(manner2Vo.getMoney());
            busCompromiseAgreement.setData2(manner2Vo.getStagingNumber());
            busCompromiseAgreement.setData3(manner2Vo.getDays());
            busCompromiseAgreement.setPartyaSubrogation(manner2Vo.getPartyaSubrogation());
            busCompromiseAgreement.setPartyaDate(manner2Vo.getPartyaDate());
            busCompromiseAgreement.setPartyaSeal(manner2Vo.getPartyaSeal());
            busCompromiseAgreement.setPartybSeal(manner2Vo.getPartybSeal());
            busCompromiseAgreement.setPartybDate(manner2Vo.getPartybDate());
            int insertSelective = busCompromiseAgreementDao.updateByPrimaryKeySelective(busCompromiseAgreement);
            log.info("更新资产和解协议全款成功受影响行数:{}",insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("更新资产和解协议全款失败,异常信息:{}",e.getMessage());
            throw new CustomerException("更新资产和解协议全款失败");
        }
    }


    @Override
    public List<Manner1AndManner2> queryList() throws CustomerException {
        List<Manner1AndManner2> list = new ArrayList<>();
        List<BusCompromiseAgreement> busCompromiseAgreements = busCompromiseAgreementDao.queryList();
        for (BusCompromiseAgreement item: busCompromiseAgreements) {
            Manner1AndManner2 manner1VoAndManner2Vo = selectByPrimaryKey(item.getCompromiseAgreementId());
            list.add(manner1VoAndManner2Vo);
        }
        return list;
    }

    @Override
    public BusCompromiseAgreementShow initialize(Long relativePerId) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        BusCompromiseAgreementShow initialize = busCompromiseAgreementDao.initialize(relativePerId);
        String format = simpleDateFormat.format(initialize.getCreateTime());
        Date parse = simpleDateFormat.parse(format);
        Calendar c = Calendar.getInstance();
        c.setTime(parse);
        initialize.setDay(c.get(Calendar.DAY_OF_MONTH)+"");
        return initialize;
    }

    @Override
    public Manner1AndManner2 selectByPropertId(Long propertId) throws CustomerException {
        BusCompromiseAgreement a = busCompromiseAgreementDao.selectByPropertId(propertId);
        Manner1AndManner2 manner1AndManner2 = selectByPrimaryKey(a.getCompromiseAgreementId());
        return manner1AndManner2;
    }
}
