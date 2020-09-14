package com.smart.bracelet.controller.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.user.PubRole;
import com.smart.bracelet.model.po.user.PubRoleauth;
import com.smart.bracelet.model.po.user.PubRolemenu;
import com.smart.bracelet.model.vo.user.PubRoleVo;
import com.smart.bracelet.service.debt.PubRolemenuService;
import com.smart.bracelet.service.user.PubRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

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
     *
     * @param pubRole
     * @return
     */
    @RequestMapping("/insertSelective")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public Result insertSelective(@Valid PubRole pubRole) throws CustomerException {
        int insertSelective = pubRoleService.insertSelective(pubRole);
        return Result.success(insertSelective);
    }

    /**
     * 通过ID删除角色信息
     *
     * @param roleId
     * @return
     */
    @RequestMapping("/deleteByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('user:delete')")
    public Result deleteByPrimaryKey(@NotNull(message = "角色Id不能为空") Long roleId) throws CustomerException {
        int deleteByPrimaryKey = pubRoleService.deleteByPrimaryKey(roleId);
        return Result.success(deleteByPrimaryKey);
    }

    /**
     * 修改角色信息
     *
     * @param record
     * @return
     */
    @RequestMapping("/updateByPrimaryKeySelective")
    @PreAuthorize("hasAnyAuthority('user: update')")
    public Result updateByPrimaryKeySelective(@Valid PubRoleVo record) throws CustomerException {
        int updateByPrimaryKeySelective = pubRoleService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    /**
     * 通过Id查询角色信息
     *
     * @param roleId
     * @return
     */
    @RequestMapping("/selectByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('user:select')")
    public Result<PubRole> selectByPrimaryKey(@NotNull(message = "角色Id不能为空") Long roleId) {
        PubRole pubRole = pubRoleService.selectByPrimaryKey(roleId);
        return Result.success(pubRole);
    }

    /**
     * 给角色分配权限
     *
     * @return
     * @parampubRoleauth
     */
    @RequestMapping("/addRoleAuth")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public Result addRoleAuth(@Valid PubRoleauth pubRoleauth) throws CustomerException {
        int addRoleAuth = pubRoleService.addRoleAuth(pubRoleauth);
        return Result.success(addRoleAuth);
    }

    /**
     * 批量给角色添加菜单
     *
     * @param
     * @return
     */
    @RequestMapping("/addRoleMenus")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public Result addRoleMenu(Long[] menus,@NotNull(message = "角色Id不能为空") Long roleId) throws CustomerException {
        int addRoleMenu = pubRoleService.addRoleMenu(menus,roleId);
        return Result.success(addRoleMenu);
    }

    /**
     * 批量删除角色
     *
     * @param roleIds
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/delRoleList")
    @PreAuthorize("hasAnyAuthority('user:delete')")
    public Result delRoleList(@NotNull(message = "角色Id不能为空") Long[] roleIds) throws CustomerException {
        int delRoleList = pubRoleService.delRoleList(roleIds);
        return Result.success(delRoleList);
    }

    /**
     * 批量分配角色权限
     * @param roleId
     * @param authId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/addRoleAuthList")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public Result addRoleAuthList(@NotBlank(message = "权限ID不能为空") String authId, @NotNull(message = "角色ID不能为空") Long roleId, String menuId ,String note) throws CustomerException {
        int i = pubRoleService.addRoleAuthList(authId, roleId, menuId,note);
        return Result.success(i);
    }

    @RequestMapping("/queryRole")
    @PreAuthorize("hasAnyAuthority('user:select')")
    public Result<List<PubRole>> queryRole(){
        List<PubRole> list = pubRoleService.queryRole();
        return Result.success(list);
    }
}
