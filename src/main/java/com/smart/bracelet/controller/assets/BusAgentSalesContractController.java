package com.smart.bracelet.controller.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.assets.BusAgentSalesContract;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractShow;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractVo;
import com.smart.bracelet.service.assets.BusAgentSalesContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping("/api/busAgentSalesContractController")
public class BusAgentSalesContractController {

    @Autowired
    private BusAgentSalesContractService busAgentSalesContractService;

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "代理销售合同ID不能为空") Long salesContractId) throws CustomerException {
        int i = busAgentSalesContractService.deleteByPrimaryKey(salesContractId);
        return Result.success(i);
    }

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusAgentSalesContract record) throws CustomerException {
        int i = busAgentSalesContractService.insertSelective(record);
        return Result.success(i);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<BusAgentSalesContract> selectByPrimaryKey(@NotNull(message = "代理销售合同ID不能为空") Long salesContractId) {
        BusAgentSalesContract busAgentSalesContract = busAgentSalesContractService.selectByPrimaryKey(salesContractId);
        return Result.success(busAgentSalesContract);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusAgentSalesContractVo record) throws CustomerException {
        int i = busAgentSalesContractService.updateByPrimaryKeySelective(record);
        return Result.success(i);
    }

    /**
     * 委托代理销售合同初始化
     * @param reportId
     * @return
     */
    @RequestMapping("/initialize")
    public Result<BusAgentSalesContractShow> initialize(@NotNull(message = "报备ID不能为空") Long reportId) throws CustomerException {
        BusAgentSalesContractShow initialize = busAgentSalesContractService.initialize(reportId);
        return Result.success(initialize);
    }

}
