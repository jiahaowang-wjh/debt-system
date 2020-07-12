package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusCivil;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.debt.BusCivilVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusCivilDao {
    int deleteByPrimaryKey(Long civilId);

    int insertSelective(BusCivil record);

    BusCivil selectByPrimaryKey(Long civilId);

    int updateByPrimaryKeySelective(BusCivilVo record);

    /**
     * 按照日期查询每日报备数量
     * @return
     */
    List<DateAndDays> selectDaysCount();
}