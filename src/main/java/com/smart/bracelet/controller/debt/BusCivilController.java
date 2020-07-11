package com.smart.bracelet.controller.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusCivil;
import com.smart.bracelet.model.vo.debt.BusCivilVo;
import com.smart.bracelet.service.debt.BusCivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/busCivilController/")
@Validated
public class BusCivilController {

    @Autowired
    private BusCivilService busCivilService;

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusCivil record) throws CustomerException {
        int insertSelective = busCivilService.insertSelective(record);
        return Result.success(insertSelective);
    }

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "民事调解Id不能为空") Long civilId) throws CustomerException{
        int deleteByPrimaryKey = busCivilService.deleteByPrimaryKey(civilId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusCivilVo record) throws CustomerException{
        int updateByPrimaryKeySelective = busCivilService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<BusCivil> selectByPrimaryKey(@NotNull(message = "民事调解Id不能为空")Long civilId){
        BusCivil busCivil = busCivilService.selectByPrimaryKey(civilId);
        return Result.success(busCivil);
    }

}
