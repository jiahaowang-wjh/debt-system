package com.smart.bracelet.controller.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusRealAuth;
import com.smart.bracelet.model.vo.debt.BusRealAuthVo;
import com.smart.bracelet.service.debt.BusRealAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/busRealAuthController/")
@Validated
public class BusRealAuthController {

    @Autowired
    private BusRealAuthService busRealAuthService;

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusRealAuth record) throws CustomerException {
        int insertSelective = busRealAuthService.insertSelective(record);
        return Result.success(insertSelective);
    }

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "实名ID不能为空") Long realId) throws CustomerException {
        int deleteByPrimaryKey = busRealAuthService.deleteByPrimaryKey(realId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusRealAuthVo record) throws CustomerException {
        int updateByPrimaryKeySelective = busRealAuthService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<BusRealAuth> selectByPrimaryKey(@NotNull(message = "实名ID不能为空") Long realId) {
        BusRealAuth busRealAuth = busRealAuthService.selectByPrimaryKey(realId);
        return Result.success(busRealAuth);
    }
}
