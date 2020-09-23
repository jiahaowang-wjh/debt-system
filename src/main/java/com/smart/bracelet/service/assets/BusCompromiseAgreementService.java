package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusCompromiseAgreement;
import com.smart.bracelet.model.po.assets.Manner1;
import com.smart.bracelet.model.po.assets.Manner1AndManner2;
import com.smart.bracelet.model.po.assets.Manner2;
import com.smart.bracelet.model.vo.assets.BusCompromiseAgreementShow;
import com.smart.bracelet.model.vo.assets.Manner1Vo;
import com.smart.bracelet.model.vo.assets.Manner2Vo;

import java.text.ParseException;
import java.util.List;

public interface BusCompromiseAgreementService {

    int deleteByPrimaryKey(Long compromiseAgreementId) throws CustomerException;

    int insertSelectiveManner1(Manner1 manner1Vo) throws CustomerException;

    int insertSelectiveManner2(Manner2 manner2Vo) throws CustomerException;

    Manner1AndManner2 selectByPrimaryKey(Long compromiseAgreementId) throws CustomerException;

    int updateByPrimaryKeySelectiveManner1Vo(Manner1Vo record) throws CustomerException;

    int updateByPrimaryKeySelectiveManner2Vo(Manner2Vo record) throws CustomerException;

    List<Manner1AndManner2> queryList() throws CustomerException;

    /**
     * 初始化和解协议页面
     * @param propertId
     * @return
     */
    BusCompromiseAgreementShow initialize(Long propertId,Long comId) throws ParseException;

    /**
     * 通过资产Id查询解协议
     * @param propertId
     * @return
     */
    Manner1AndManner2 selectByPropertId(Long propertId) throws CustomerException;
}
