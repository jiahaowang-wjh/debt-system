package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusMediatePerson;
import com.smart.bracelet.model.vo.debt.BusMediatePersonVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusMediatePersonDao {

    int deleteByPrimaryKey(Long mediatePersonId);

    int insertSelective(BusMediatePerson record);

    BusMediatePerson selectByPrimaryKey(Long mediatePersonId);

    int updateByPrimaryKeySelective(BusMediatePersonVo record);

    List<BusMediatePerson> queryList();

}