package com.smart.bracelet.controller.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusInvestigateReport;
import com.smart.bracelet.model.vo.debt.BusInvestigateReportVo;
import com.smart.bracelet.service.debt.BusInvestigateReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/busInvestigateReportController/")
@Validated
public class BusInvestigateReportController {

    @Autowired
    private BusInvestigateReportService busInvestigateReportService;

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "报告ID不能为空") Long reportId) throws CustomerException {
        int i = busInvestigateReportService.deleteByPrimaryKey(reportId);
        return Result.success(i);
    }

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusInvestigateReport record) throws CustomerException {
        Long i = busInvestigateReportService.insertSelective(record);
        return Result.success(i+"");
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<BusInvestigateReport> selectByPrimaryKey(@NotNull(message = "报告ID不能为空") Long reportId) {
        BusInvestigateReport busInvestigateReport = busInvestigateReportService.selectByPrimaryKey(reportId);
        return Result.success(busInvestigateReport);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusInvestigateReportVo record) throws CustomerException {
        int i = busInvestigateReportService.updateByPrimaryKeySelective(record);
        return Result.success(i);
    }

}
