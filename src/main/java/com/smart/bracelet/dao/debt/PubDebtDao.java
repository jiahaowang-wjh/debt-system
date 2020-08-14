package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.po.debt.PubDebt;
import com.smart.bracelet.model.vo.debt.PubDebtShowList;
import com.smart.bracelet.model.vo.debt.PubDebtVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PubDebtDao {

    int deleteByPrimaryKey(Long debtId);

    int insertSelective(PubDebt record);

    PubDebt selectByPrimaryKey(Long debtId);

    int updateByPrimaryKeySelective(PubDebtVo record);

    /**
     * 查询每日解债信息
     * @return
     */
    List<DateAndDays> selectDaysCount();


    /**
     * 查询所有借债信息
     * @return
     */
    List<PubDebt> queryList();


    /**
     * 更新审核状态
     * @param status
     * @param debtId
     * @return
     */
    int updateStatus(String status,Long debtId);

    /**
     * 查询最后一个解债编号
     * @return
     */
    String selectRepNo();


    /**
     * 页面解债信息展示
     */
    List<PubDebtShowList> queryListShow();
}