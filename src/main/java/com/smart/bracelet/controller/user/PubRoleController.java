package com.smart.bracelet.controller.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.user.PubRole;
import com.smart.bracelet.model.po.user.PubRoleauth;
import com.smart.bracelet.model.po.user.PubRolemenu;
import com.smart.bracelet.model.vo.user.PubRoleVo;
import com.smart.bracelet.service.user.PubRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 角色管理
 */
@RestController
@RequestMapping("/api/pubRoleController/")
@Validated
public class PubRoleController {

    @Autowired
    private PubRoleService pubRoleService;

    /**
     * 新增角色信息
     * @param pubRole
     * @return
     */
    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid PubRole pubRole) throws CustomerException {
        int insertSelective = pubRoleService.insertSelective(pubRole);
        return Result.success(insertSelective);
    }

    /**
     * 通过ID删除角色信息
     * @param roleId
     * @return
     */
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "角色Id不能为空") Long roleId) throws CustomerException {
        int deleteByPrimaryKey = pubRoleService.deleteByPrimaryKey(roleId);
        return Result.success(deleteByPrimaryKey);
    }
    /**
     * 修改角色信息
     * @param record
     * @return
     */
    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid PubRoleVo record) throws CustomerException {
        int updateByPrimaryKeySelective = pubRoleService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }
    /**
     * 通过Id查询角色信息
     * @param roleId
     * @return
     */
    @RequestMapping("/selectByPrimaryKey")
    public Result<PubRole> selectByPrimaryKey(@NotNull(message = "角色Id不能为空") Long roleId) {
        PubRole pubRole = pubRoleService.selectByPrimaryKey(roleId);
        return Result.success(pubRole);
    }

    /**
     * 给角色分配权限
     * @parampubRoleauth
     * @return
     */
    @RequestMapping("/addRoleAuth")
    public Result addRoleAuth(@Valid PubRoleauth pubRoleauth) throws CustomerException {
        int addRoleAuth = pubRoleService.addRoleAuth(pubRoleauth);
        return Result.success(addRoleAuth);
    }
    /**
     * 给角色添加菜单
     * @param pubRolemenu
     * @return
     */
    @RequestMapping("/addRoleMenu")
    public Result addRoleMenu(@Valid PubRolemenu pubRolemenu) throws CustomerException{
        int addRoleMenu = pubRoleService.addRoleMenu(pubRolemenu);
        return Result.success(addRoleMenu);
    }
}
