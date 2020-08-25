package com.smart.bracelet.controller.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusGuarantee;
import com.smart.bracelet.model.vo.debt.BusGuaranteeVo;
import com.smart.bracelet.service.debt.BusGuaranteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 担保人信息表现层
 */
@RestController
@RequestMapping("/api/busGuaranteeController/")
@Validated
public class BusGuaranteeController {

    @Autowired
    private BusGuaranteeService busGuaranteeService;

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusGuarantee record) throws CustomerException {
        int insertSelective = busGuaranteeService.insertSelective(record);
        return Result.success(insertSelective);
    }

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "担保人ID不能为空") Long guaranteeId) throws CustomerException {
        int deleteByPrimaryKey = busGuaranteeService.deleteByPrimaryKey(guaranteeId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusGuaranteeVo record) throws CustomerException {
        int updateByPrimaryKeySelective = busGuaranteeService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<BusGuarantee> selectByPrimaryKey(@NotNull(message = "担保人ID不能为空") Long guaranteeId) {
        BusGuarantee busGuarantee = busGuaranteeService.selectByPrimaryKey(guaranteeId);
        return Result.success(busGuarantee);
    }

}
