package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusConfirm;
import com.smart.bracelet.model.vo.assets.BusConfirmShow;
import com.smart.bracelet.model.vo.assets.BusConfirmVo;

import java.text.ParseException;
import java.util.List;

public interface BusConfirmService {

    int deleteByPrimaryKey(Long confirmtId) throws CustomerException;

    int insertSelective(BusConfirm record) throws CustomerException;

    BusConfirm selectByPrimaryKey(Long confirmtId);

    int updateByPrimaryKeySelective(BusConfirmVo record) throws CustomerException;

    List<BusConfirm> queryList();


    /**
     * 资产债权确认页面初始化
     *
     * @param relativePerId
     * @return
     */
    BusConfirmShow initialize(Long relativePerId) throws ParseException;

    /**
     * 通过资产ID查询资产债权确认
     * @param propertId
     * @return
     */
    BusConfirm selectByPropertId(Long propertId);

}
