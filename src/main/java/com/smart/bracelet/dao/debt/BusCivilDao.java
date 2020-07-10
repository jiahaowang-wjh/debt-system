package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusCivil;
import org.springframework.stereotype.Repository;

@Repository
public interface BusCivilDao {
    int deleteByPrimaryKey(Long civilId);

    int insert(BusCivil record);

    int insertSelective(BusCivil record);

    BusCivil selectByPrimaryKey(Long civilId);

    int updateByPrimaryKeySelective(BusCivil record);

    int updateByPrimaryKey(BusCivil record);
}