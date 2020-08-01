package com.smart.bracelet.controller.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusPropertPromise;
import com.smart.bracelet.model.vo.debt.BusPropertPromiseVo;
import com.smart.bracelet.service.debt.BusPropertPromiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/busPropertPromiseController/")
@Validated
public class BusPropertPromiseController {

    @Autowired
    private BusPropertPromiseService busPropertPromiseService;

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "承诺书ID不能为空") Long promiseId) throws CustomerException {
        int deleteByPrimaryKey = busPropertPromiseService.deleteByPrimaryKey(promiseId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusPropertPromise record) throws CustomerException {
        int insertSelective = busPropertPromiseService.insertSelective(record);
        return Result.success(insertSelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<BusPropertPromise> selectByPrimaryKey(@NotNull(message = "承诺书ID不能为空") Long promiseId) throws CustomerException {
        BusPropertPromise busPropertPromise = busPropertPromiseService.selectByPrimaryKey(promiseId);
        return Result.success(busPropertPromise);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusPropertPromiseVo record) throws CustomerException {
        int updateByPrimaryKeySelective = busPropertPromiseService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/queryList")
    public Result<List<BusPropertPromise>> queryList() {
        List<BusPropertPromise> busPropertPromises = busPropertPromiseService.queryList();
        return Result.success(busPropertPromises);
    }
}