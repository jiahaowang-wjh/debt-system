package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusCollectionLetter;
import com.smart.bracelet.model.vo.assets.BusCollectionLetterVo;

import java.util.List;

public interface BusCollectionLetterService {

    int deleteByPrimaryKey(Long collectionLettertId) throws CustomerException;

    int insertSelective(BusCollectionLetter record) throws CustomerException;

    BusCollectionLetter selectByPrimaryKey(Long collectionLettertId);

    int updateByPrimaryKeySelective(BusCollectionLetterVo record) throws CustomerException;

    List<BusCollectionLetter> queryList();

}
