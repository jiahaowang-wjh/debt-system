package com.smart.bracelet.controller.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.PubExp;
import com.smart.bracelet.model.vo.PubExpVo;
import com.smart.bracelet.service.PubExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 公式信息管理
 */
@RestController
@RequestMapping("/api/pubExpController/")
@Validated
public class PubExpController {

    @Autowired
    private PubExpService pubExpService;

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid PubExp record) throws CustomerException{
        int insertSelective = pubExpService.insertSelective(record);
        return Result.success(insertSelective);
    }

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "公式ID不能为空") Long expId) throws CustomerException{
        int deleteByPrimaryKey = pubExpService.deleteByPrimaryKey(expId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid PubExpVo record) throws CustomerException{
        int updateByPrimaryKeySelective = pubExpService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<PubExp> selectByPrimaryKey(@NotNull(message = "公式ID不能为空") Long expId){
        PubExp pubExp = pubExpService.selectByPrimaryKey(expId);
        return Result.success(pubExp);
    }

}
