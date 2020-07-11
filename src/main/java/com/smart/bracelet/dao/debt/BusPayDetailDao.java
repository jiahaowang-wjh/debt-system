package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusPayDetail;
import com.smart.bracelet.model.vo.debt.BusPayDetailVo;
import org.springframework.stereotype.Repository;

@Repository
public interface BusPayDetailDao {
    int deleteByPrimaryKey(Long payId);

    int insertSelective(BusPayDetail record);

    BusPayDetail selectByPrimaryKey(Long payId);

    int updateByPrimaryKeySelective(BusPayDetailVo record);

}