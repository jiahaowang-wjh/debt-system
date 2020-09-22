package com.smart.bracelet.controller.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusInvestigateReport;
import com.smart.bracelet.service.debt.BusInvestigateReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/busInvestigateReportController/")
@Validated
public class BusInvestigateReportController {

    @Autowired
    private BusInvestigateReportService busInvestigateReportService;

    @RequestMapping("/insert")
    public Result insert(@Valid BusInvestigateReport record) throws CustomerException {
        Long insert = busInvestigateReportService.insert(record);
        return Result.success(insert + "");
    }

    /**
     * selectByPrimaryKey
     *
     * @param reportId
     * @return
     */
    @RequestMapping("/selectByPrimaryKey")
    public Result<BusInvestigateReport> selectByPrimaryKey(Long reportId) {
        BusInvestigateReport busInvestigateReport = busInvestigateReportService.selectByPrimaryKey(reportId);
        return Result.success(busInvestigateReport);
    }


}
