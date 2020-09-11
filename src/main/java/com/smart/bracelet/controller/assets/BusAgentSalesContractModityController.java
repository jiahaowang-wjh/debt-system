package com.smart.bracelet.controller.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.assets.BusAgentSalesContractModity;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractModityVo;
import com.smart.bracelet.service.assets.BusAgentSalesContractModityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping("/api/busAgentSalesContractModityController")
public class BusAgentSalesContractModityController {

    @Autowired
    private BusAgentSalesContractModityService busAgentSalesContractModityService;

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "代理销售合同商品ID不能为空") Long salesContractModityId) throws CustomerException {
        int i = busAgentSalesContractModityService.deleteByPrimaryKey(salesContractModityId);
        return Result.success(i);
    }

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusAgentSalesContractModity record) throws CustomerException {
        Long i = busAgentSalesContractModityService.insertSelective(record);
        return Result.success(i+"");
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<BusAgentSalesContractModity> selectByPrimaryKey(@NotNull(message = "代理销售合同商品ID不能为空") Long salesContractModityId) {
        BusAgentSalesContractModity busAgentSalesContractModity = busAgentSalesContractModityService.selectByPrimaryKey(salesContractModityId);
        return Result.success(busAgentSalesContractModity);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusAgentSalesContractModityVo record) throws CustomerException {
        int i = busAgentSalesContractModityService.updateByPrimaryKeySelective(record);
        return Result.success(i);
    }

    /**
     * 通过资产委托代理销售合同id查询
     * @param salesContractId
     * @return
     */
    @RequestMapping("/selectBySalesContractId")
    public Result<BusAgentSalesContractModity> selectBySalesContractId(@NotNull(message = "资产委托代理销售合同ID不能为空") Long salesContractId){
        BusAgentSalesContractModity busAgentSalesContractModity = busAgentSalesContractModityService.selectBySalesContractId(salesContractId);
        return Result.success(busAgentSalesContractModity);
    }

}
