package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusRelativePerson;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRelativePersonDao {
    int deleteByPrimaryKey(Long relativePerId);

    int insert(BusRelativePerson record);

    int insertSelective(BusRelativePerson record);

    BusRelativePerson selectByPrimaryKey(Long relativePerId);

    int updateByPrimaryKeySelective(BusRelativePerson record);

    int updateByPrimaryKey(BusRelativePerson record);
}