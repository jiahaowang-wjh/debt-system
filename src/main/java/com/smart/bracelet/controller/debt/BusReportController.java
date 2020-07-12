package com.smart.bracelet.controller.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusReport;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.debt.BusReportVo;
import com.smart.bracelet.service.debt.BusReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 报备信息表现层
 */
@RestController
@RequestMapping("/api/busReportController/")
@Validated
public class BusReportController {

    @Autowired
    private BusReportService busReportService;

    /**
     * 新增报备信息
     * @param record
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusReport record) throws CustomerException{
        int insertSelective = busReportService.insertSelective(record);
        return Result.success(insertSelective);
    }

    /**
     * 通过Id删除报备信息
     * @param reportId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "报备信息Id不能为空") Long reportId) throws CustomerException{
        int deleteByPrimaryKey = busReportService.deleteByPrimaryKey(reportId);
        return Result.success(deleteByPrimaryKey);
    }

    /**
     * 更新报备信息
     * @param record
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusReportVo record) throws CustomerException{
        int updateByPrimaryKeySelective = busReportService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    /**
     * 通过Id查询报备信息
     * @param reportId
     * @return
     */
    @RequestMapping("/selectByPrimaryKey")
    public Result<BusReport> selectByPrimaryKey(@NotNull(message = "报备信息Id不能为空")Long reportId){
        BusReport busReport = busReportService.selectByPrimaryKey(reportId);
        return Result.success(busReport);
    }

    /**
     * 查询所有报备信息
     * @return
     */
    @RequestMapping("/queryBusReport")
    public Result<List<BusReport>> queryBusReport(){
        List<BusReport> busReports = busReportService.queryBusReport();
        return Result.success(busReports);
    }

    /**
     * 按照日期查询每日报备数量
     * @return
     */
    @RequestMapping("/selectDaysCount")
    public Result<List<DateAndDays>> selectDaysCount(){
        List<DateAndDays> busReports = busReportService.selectDaysCount();
        return Result.success(busReports);
    }
}
