package com.smart.bracelet.controller.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.assets.BusAgentSalesContract;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractVo;
import com.smart.bracelet.service.assets.BusAgentSalesContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/busAgentSalesContractController/")
@Validated
public class BusAgentSalesContractController {

    @Autowired
    private BusAgentSalesContractService busAgentSalesContractService;

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "代理销售合同ID不能为空") Long salesContractId) throws CustomerException {
        int deleteByPrimaryKey = busAgentSalesContractService.deleteByPrimaryKey(salesContractId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusAgentSalesContract record) throws CustomerException {
        int insertSelective = busAgentSalesContractService.insertSelective(record);
        return Result.success(insertSelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<BusAgentSalesContract> selectByPrimaryKey(@NotNull(message = "代理销售合同ID不能为空") Long salesContractId) {
        BusAgentSalesContract busAgentSalesContract = busAgentSalesContractService.selectByPrimaryKey(salesContractId);
        return Result.success(busAgentSalesContract);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusAgentSalesContractVo record) throws CustomerException {
        int updateByPrimaryKeySelective = busAgentSalesContractService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/queryList")
    public Result<List<BusAgentSalesContract>> queryList() {
        List<BusAgentSalesContract> busAgentSalesContracts = busAgentSalesContractService.queryList();
        return Result.success(busAgentSalesContracts);
    }

}
