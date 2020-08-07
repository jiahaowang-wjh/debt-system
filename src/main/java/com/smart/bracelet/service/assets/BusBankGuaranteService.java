package com.smart.bracelet.service.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.assets.BusBankGuarante;
import com.smart.bracelet.model.vo.assets.BusBankGuaranteVo;

import java.util.List;

public interface BusBankGuaranteService {
    int deleteByPrimaryKey(Long bankGuaranteId) throws CustomerException;

    int insertSelective(BusBankGuarante record) throws CustomerException;

    BusBankGuarante selectByPrimaryKey(Long bankGuaranteId);

    int updateByPrimaryKeySelective(BusBankGuaranteVo record) throws CustomerException;

    List<BusBankGuarante> queryList();


}
