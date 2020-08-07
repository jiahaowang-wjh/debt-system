package com.smart.bracelet.dao.assets;

import com.smart.bracelet.model.po.assets.BusBankGuarante;
import com.smart.bracelet.model.vo.assets.BusBankGuaranteVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusBankGuaranteDao {
    int deleteByPrimaryKey(Long bankGuaranteId);

    int insertSelective(BusBankGuarante record);

    BusBankGuarante selectByPrimaryKey(Long bankGuaranteId);

    int updateByPrimaryKeySelective(BusBankGuaranteVo record);

    List<BusBankGuarante> queryList();
}