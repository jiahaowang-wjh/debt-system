package com.smart.bracelet.controller.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusPledgeProperty;
import com.smart.bracelet.model.vo.debt.BusPledgePropertyVo;
import com.smart.bracelet.service.debt.BusPledgePropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/busPledgePropertycontroller/")
@Validated
public class BusPledgePropertyController {

    @Autowired
    private BusPledgePropertyService busPledgePropertyService;

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "不能为空质押财产ID") Long pledgePropertyId) throws CustomerException {
        int deleteByPrimaryKey = busPledgePropertyService.deleteByPrimaryKey(pledgePropertyId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusPledgeProperty record) throws CustomerException {
        int insertSelective = busPledgePropertyService.insertSelective(record);
        return Result.success(insertSelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<BusPledgeProperty> selectByPrimaryKey(@NotNull(message = "不能为空质押财产ID") Long pledgePropertyId) {
        BusPledgeProperty busPledgeProperty = busPledgePropertyService.selectByPrimaryKey(pledgePropertyId);
        return Result.success(busPledgeProperty);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusPledgePropertyVo record) throws CustomerException {
        int updateByPrimaryKeySelective = busPledgePropertyService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/queryList")
    public Result<List<BusPledgeProperty>> queryList() {
        List<BusPledgeProperty> busPledgeProperties = busPledgePropertyService.queryList();
        return Result.success(busPledgeProperties);
    }


}
