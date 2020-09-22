package com.smart.bracelet.controller.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.user.PubExp;
import com.smart.bracelet.model.vo.user.PubExpVo;
import com.smart.bracelet.service.user.PubExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

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
    public Result insertSelective(@Valid PubExp record) throws CustomerException {
        int insertSelective = pubExpService.insertSelective(record);
        return Result.success(insertSelective);
    }

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "公式ID不能为空") Long expId) throws CustomerException {
        int deleteByPrimaryKey = pubExpService.deleteByPrimaryKey(expId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid PubExpVo record) throws CustomerException {
        int updateByPrimaryKeySelective = pubExpService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<PubExp> selectByPrimaryKey(@NotNull(message = "公式ID不能为空") Long expId) {
        PubExp pubExp = pubExpService.selectByPrimaryKey(expId);
        return Result.success(pubExp);
    }

    /**
     * 查询所有公式
     *
     * @return
     */
    @RequestMapping("/queryExpList")
    public Result<List<PubExp>> queryExpList() {
        List<PubExp> pubExps = pubExpService.queryExpList();
        return Result.success(pubExps);
    }

    /**
     * 批量删除公式信息
     *
     * @param expIds
     * @return
     */
    @RequestMapping("/delExpList")
    public Result delExpList(@NotNull(message = "公式ID不能为空") Long[] expIds) throws CustomerException {
        int delExpList = pubExpService.delExpList(expIds);
        return Result.success(delExpList);
    }
}
