package com.smart.bracelet.controller.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusPledgeContract;
import com.smart.bracelet.model.vo.debt.BusPledgeContractVo;
import com.smart.bracelet.service.debt.BusPledgeContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/busPledgeContractController/")
@Validated
public class BusPledgeContractController {

    @Autowired
    private BusPledgeContractService busPledgeContractService;

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "质押合同ID不能为空") Long pledgeContractId) throws CustomerException {
        int deleteByPrimaryKey = busPledgeContractService.deleteByPrimaryKey(pledgeContractId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusPledgeContract record) throws CustomerException {
        int insertSelective = busPledgeContractService.insertSelective(record);
        return Result.success(insertSelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<BusPledgeContract> selectByPrimaryKey(@NotNull(message = "质押合同ID不能为空") Long pledgeContractId) {
        BusPledgeContract busPledgeContract = busPledgeContractService.selectByPrimaryKey(pledgeContractId);
        return Result.success(busPledgeContract);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusPledgeContractVo record) throws CustomerException {
        int updateByPrimaryKeySelective = busPledgeContractService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/queryList")
    public Result<List<BusPledgeContract>> queryList() {
        List<BusPledgeContract> busPledgeContracts = busPledgeContractService.queryList();
        return Result.success(busPledgeContracts);
    }

}
