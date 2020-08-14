package com.smart.bracelet.service.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.debt.BusCivil;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.debt.BusCivilInfo;
import com.smart.bracelet.model.vo.debt.BusCivilShowList;
import com.smart.bracelet.model.vo.debt.BusCivilVo;
import com.smart.bracelet.model.vo.debt.DebtInfoQuery;

import java.util.List;

public interface BusCivilService {
    int deleteByPrimaryKey(Long civilId) throws CustomerException;

    int insertSelective(BusCivil record) throws CustomerException;

    BusCivil selectByPrimaryKey(Long civilId);

    int updateByPrimaryKeySelective(BusCivilVo record) throws CustomerException;

    /**
     * 按照日期查询每日报备数量
     * @return
     */
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
    int updateStatus(String status,Long civilId) throws CustomerException;

    /**
     * 页面展示民事调解信息
     */
    List<BusCivilInfo> selectBusList(DebtInfoQuery debtInfoQuery);

}
