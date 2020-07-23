package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusPayDetail;
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

}