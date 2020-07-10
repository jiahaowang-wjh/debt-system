package com.smart.bracelet.dao.user;

import com.smart.bracelet.model.po.user.BusPayDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface BusPayDetailDao {
    int deleteByPrimaryKey(Long payId);

    int insert(BusPayDetail record);

    int insertSelective(BusPayDetail record);

    BusPayDetail selectByPrimaryKey(Long payId);

    int updateByPrimaryKeySelective(BusPayDetail record);

    int updateByPrimaryKey(BusPayDetail record);
}