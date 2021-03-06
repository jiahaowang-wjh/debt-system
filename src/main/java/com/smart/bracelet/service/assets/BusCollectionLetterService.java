package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusCollectionLetter;
import com.smart.bracelet.model.vo.assets.BusCollectionLetterShow;
import com.smart.bracelet.model.vo.assets.BusCollectionLetterVo;
import com.smart.bracelet.model.vo.assets.BusConfirmShow;

import java.text.ParseException;
import java.util.List;

public interface BusCollectionLetterService {

    int deleteByPrimaryKey(Long collectionLettertId) throws CustomerException;

    int insertSelective(BusCollectionLetter record) throws CustomerException;

    BusCollectionLetter selectByPrimaryKey(Long collectionLettertId);

    int updateByPrimaryKeySelective(BusCollectionLetterVo record) throws CustomerException;

    List<BusCollectionLetter> queryList();

    /**
     * 资产债权确认页面初始化
     * @param propertId
     * @return
     */
    BusCollectionLetterShow initialize(Long propertId,Long comId) throws ParseException;
    /**
     * 通过资产Id查询催款函
     * @param propertId
     * @return
     */
    BusCollectionLetter selectByPropertId(Long propertId);
}
