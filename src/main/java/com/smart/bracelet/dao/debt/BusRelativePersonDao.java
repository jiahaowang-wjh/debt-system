package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.debt.BusRelativePerson;
import com.smart.bracelet.model.vo.debt.AuxiliaryDownload;
import com.smart.bracelet.model.vo.debt.BusRelativePersonVo;
import com.smart.bracelet.model.vo.debt.ReportAndRelativePerson;
import com.smart.bracelet.model.vo.debt.ReportAndRelativePersonShow;
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
     * 根据报备ID查询相对人信息
     */
    List<BusRelativePerson> selectByreportId(Long reportId);

    /**
     * 通过相对人ID查询相对人债事人信息
     * @param relativePerId
     * @return
     */
    ReportAndRelativePerson selectByRelativePerId(Long relativePerId);

    /**
     * 辅助下载
     */
    List<AuxiliaryDownload> selectDow();

    String selectNo();
}