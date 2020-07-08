package com.smart.bracelet.controller.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.PubRole;
import com.smart.bracelet.model.po.PubRoleauth;
import com.smart.bracelet.model.vo.PubRoleVo;
import com.smart.bracelet.service.PubRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/pubRoleController/")
@Validated
public class PubRoleController {

    @Autowired
    private PubRoleService pubRoleService;

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid PubRole pubRole) throws CustomerException {
        int insertSelective = pubRoleService.insertSelective(pubRole);
        return Result.success(insertSelective);
    }

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "角色Id不能为空") Long roleId) throws CustomerException {
        int deleteByPrimaryKey = pubRoleService.deleteByPrimaryKey(roleId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid PubRoleVo record) throws CustomerException {
        int updateByPrimaryKeySelective = pubRoleService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<PubRole> selectByPrimaryKey(@NotNull(message = "角色Id不能为空") Long roleId) {
        PubRole pubRole = pubRoleService.selectByPrimaryKey(roleId);
        return Result.success(pubRole);
    }

    @RequestMapping("/addRoleAuth")
    public Result addRoleAuth(@Valid PubRoleauth pubRoleauth) throws CustomerException {
        int addRoleAuth = pubRoleService.addRoleAuth(pubRoleauth);
        return Result.success(addRoleAuth);
    }

}
