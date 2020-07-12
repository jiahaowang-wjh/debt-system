package com.smart.bracelet.controller.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.PubDebt;
import com.smart.bracelet.model.vo.debt.PubDebtVo;
import com.smart.bracelet.service.debt.PubDebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/pubDebtController/")
@Validated
public class PubDebtController {

    @Autowired
    private PubDebtService pubDebtService;

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid PubDebt record) throws CustomerException{
        int insertSelective = pubDebtService.insertSelective(record);
        return Result.success(insertSelective);
    }
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "解债信息Id不能为空") Long debtId) throws CustomerException{
        int deleteByPrimaryKey = pubDebtService.deleteByPrimaryKey(debtId);
        return Result.success(deleteByPrimaryKey);
    }
    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid PubDebtVo record) throws CustomerException{
        int updateByPrimaryKeySelective = pubDebtService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }
    @RequestMapping("/selectByPrimaryKey")
    public Result<PubDebt> selectByPrimaryKey(@NotNull(message = "解债信息Id不能为空")Long debtId){
        PubDebt pubDebt = pubDebtService.selectByPrimaryKey(debtId);
        return Result.success(pubDebt);
    }

}