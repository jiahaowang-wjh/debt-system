package com.smart.bracelet.controller.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.assets.BusAgentSalesContract;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractShow;
import com.smart.bracelet.model.vo.assets.BusAgentSalesContractVo;
import com.smart.bracelet.service.assets.BusAgentSalesContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('assets:delete')")
    public Result deleteByPrimaryKey(@NotNull(message = "代理销售合同ID不能为空") Long salesContractId) throws CustomerException {
        int i = busAgentSalesContractService.deleteByPrimaryKey(salesContractId);
        return Result.success(i);
    }

    @RequestMapping("/insertSelective")
    @PreAuthorize("hasAnyAuthority('assets:add')")
    public Result insertSelective(@Valid BusAgentSalesContract record) throws CustomerException {
        Long i = busAgentSalesContractService.insertSelective(record);
        return Result.success(i + "");
    }

    @RequestMapping("/selectByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('assets:select')")
    public Result<BusAgentSalesContract> selectByPrimaryKey(@NotNull(message = "代理销售合同ID不能为空") Long salesContractId) {
        BusAgentSalesContract busAgentSalesContract = busAgentSalesContractService.selectByPrimaryKey(salesContractId);
        return Result.success(busAgentSalesContract);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    @PreAuthorize("hasAnyAuthority('assets:update')")
    public Result updateByPrimaryKeySelective(@Valid BusAgentSalesContractVo record) throws CustomerException {
        int i = busAgentSalesContractService.updateByPrimaryKeySelective(record);
        return Result.success(i);
    }

    /**
     * 委托代理销售合同初始化
     *
     * @param
     * @return
     */
    @RequestMapping("/initialize")
    @PreAuthorize("hasAnyAuthority('assets:select')")
    public Result<BusAgentSalesContractShow> initialize(@NotNull(message = "相对人ID不能为空") Long relativePerId) throws CustomerException {
        BusAgentSalesContractShow initialize = busAgentSalesContractService.initialize(relativePerId);
        return Result.success(initialize);
    }

    /**
     * 通过资产Id查询 委托代理销售合同
     *
     * @param propertId
     * @return
     */
    @RequestMapping("/selectByPropertId")
    @PreAuthorize("hasAnyAuthority('assets:select')")
    public Result<BusAgentSalesContract> selectByPropertId(@NotNull(message = "资产ID不能为空") Long propertId) {
        BusAgentSalesContract busAgentSalesContract = busAgentSalesContractService.selectByPropertId(propertId);
        return Result.success(busAgentSalesContract);
    }
}
