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

    List<DateAndDays> selectDaysCount();

    /**
     * 查询所有民事调解信息
     * @return
     */
    List<BusCivil> queryList();

    /**
     * 更新审核状态
     * @param status
     * @param civilId
     * @return
     */
    int updateStatus(String status,Long civilId);

    /**
     * 查询最后一条数据编号
     * @return
     */
    String selectRepNo();

}