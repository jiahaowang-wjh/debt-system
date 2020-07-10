package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusRelativePerson;
import com.smart.bracelet.model.vo.debt.BusRelativePersonVo;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRelativePersonDao {

    int deleteByPrimaryKey(Long relativePerId);

    int insertSelective(BusRelativePerson record);

    BusRelativePerson selectByPrimaryKey(Long relativePerId);

    int updateByPrimaryKeySelective(BusRelativePersonVo record);

}