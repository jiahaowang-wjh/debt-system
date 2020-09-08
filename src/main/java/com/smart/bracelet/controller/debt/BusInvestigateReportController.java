package com.smart.bracelet.controller.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusInvestigateReport;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/busInvestigateReportController/")
@Validated
public class BusInvestigateReportController {

    @RequestMapping("/insert")
     public Result insert(BusInvestigateReport record) throws CustomerException{
         return Result.success();
     }



}
