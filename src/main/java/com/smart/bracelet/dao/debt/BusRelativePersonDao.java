package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusRelativePerson;
import com.smart.bracelet.model.vo.debt.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRelativePersonDao {

    int deleteByPrimaryKey(Long relativePerId);

    int insertSelective(BusRelativePerson record);

    BusRelativePerson selectByPrimaryKey(Long relativePerId);

    int updateByPrimaryKeySelective(BusRelativePersonVo record);

    List<BusRelativePerson> queryList();

    /**
     * 根据报备ID查询相对人信息并验证符合民事调解
     */
    List<BusRelativePerson> selectByreportId(Long reportId);

    /**
     * 根据报备ID查询相对人信息并验证符合解债申请
     */
    List<Long> selectByreportIdAndDebt(Long reportId);




    /**
     * 通过相对人ID查询相对人债事人信息
     * @param relativePerId
     * @return
     */
    ReportAndRelativePerson selectByRelativePerId(Long relativePerId);

    /**
     * 辅助下载财务
     */
    List<AuxiliaryDownload> selectDow(String debtName, String time);
    /**
     * 辅助下载债务
     */
    List<DowLod> selectDebtDow(String debtName,String time);


    /**
     * 更新相对人状态
     * @param relativePerId
     * @param status
     * @return
     */
    int updateStatus(Long relativePerId,String status);

}