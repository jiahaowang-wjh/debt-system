package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusPayDetail;
import com.smart.bracelet.model.vo.debt.BusPayDetailInfo;
import com.smart.bracelet.model.vo.debt.BusPayDetailVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusPayDetailDao {
    int deleteByPrimaryKey(Long payId);

    int insertSelective(BusPayDetail record);

    BusPayDetail selectByPrimaryKey(Long payId);

    int updateByPrimaryKeySelective(BusPayDetailVo record);

    /**
     * 通过报备Id查询支付信息
     * @param reportId
     * @return
     */
    List<BusPayDetail> selectByReportId(Long reportId);

    /**
     *更新状态
     * @param status
     * @param reportId
     * @return
     */
    int updateStatus(String status,Long reportId);

    /**
     * 查询最后一条编号
     * @return
     */
    String selectRepNo();

    /**
     * 页面支付信息展示
     * @return reportNo
     */
    List<BusPayDetailInfo> selectPayInfoList(String reportNo);
}