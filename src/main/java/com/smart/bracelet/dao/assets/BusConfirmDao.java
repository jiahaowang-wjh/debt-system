package com.smart.bracelet.dao.assets;

import com.smart.bracelet.model.po.assets.BusConfirm;
import com.smart.bracelet.model.vo.assets.BusConfirmShow;
import com.smart.bracelet.model.vo.assets.BusConfirmVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusConfirmDao {

    int deleteByPrimaryKey(Long confirmtId);

    int insertSelective(BusConfirm record);

    BusConfirm selectByPrimaryKey(Long confirmtId);

    int updateByPrimaryKeySelective(BusConfirmVo record);

    List<BusConfirm> queryList();

    /**
     * 资产债权确认页面初始化
     * @param propertId
     * @return
     */
    BusConfirmShow initialize(Long propertId);

    /**
     * 通过资产ID查询资产债权确认
     * @param propertId
     * @return
     */
    BusConfirm selectByPropertId(Long propertId);

}