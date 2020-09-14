package com.smart.bracelet.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.user.PubAuth;
import com.smart.bracelet.model.vo.user.PubAuthVo;
import com.smart.bracelet.service.user.PubAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/pubAuthController/")
@Validated
public class PubAuthController {

    @Autowired
    private PubAuthService pubAuthService;

    /**
     * 权限信息新增
     *
     * @param record
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/insertSelective")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public Result insertSelective(@Valid PubAuth record) throws CustomerException {
        int insertSelective = pubAuthService.insertSelective(record);
        return Result.success(insertSelective);
    }

    /**
     * 通过Id删除权限
     *
     * @param authId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/deleteByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public Result deleteByPrimaryKey(@NotNull(message = "权限Id不能为空") Long authId) throws CustomerException {
        int deleteByPrimaryKey = pubAuthService.deleteByPrimaryKey(authId);
        return Result.success(deleteByPrimaryKey);
    }


    /**
     * 修改权限信息
     *
     * @param record
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateByPrimaryKeySelective")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public Result updateByPrimaryKeySelective(@Valid PubAuthVo record) throws CustomerException {
        int updateByPrimaryKeySelective = pubAuthService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    /**
     * 通过Id查询权限信息
     *
     * @param authId
     * @return
     */
    @RequestMapping("/selectByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public Result<PubAuth> selectByPrimaryKey(@NotNull(message = "权限Id不能为空") Long authId) {
        PubAuth pubAuth = pubAuthService.selectByPrimaryKey(authId);
        return Result.success(pubAuth);
    }

    /**
     * 权限信息分页
     *
     * @return
     */
    @RequestMapping("/selectAuthPage")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public Result<PageInfo> selectAuthPage(@NotNull(message = "页码不能为空") Integer pageNum, @NotNull(message = "当前显示条数不能为空") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PubAuth> pubAuths = pubAuthService.selectPageAuth();
        PageInfo<PubAuth> pubAuthPageInfo = new PageInfo<>(pubAuths);
        return Result.success(pubAuthPageInfo);
    }

    /**
     * 用户权限
     */
    @RequestMapping("/selectUserAuth")
    public Result<List<PubAuth>> selectUserAuth() {
        List<PubAuth> pubAuths = pubAuthService.selectUserAuth();
        return Result.success(pubAuths);
    }

    /**
     * 债务权限
     */
    @RequestMapping("/selectDebtAuth")
    public Result<List<PubAuth>> selectDebtAuth() {
        List<PubAuth> pubAuths = pubAuthService.selectDebtAuth();
        return Result.success(pubAuths);
    }

    /**
     * 资产权限
     */
    @RequestMapping("/selectAssetsAuth")
    public Result<List<PubAuth>> selectAssetsAuth() {
        List<PubAuth> pubAuths = pubAuthService.selectAssetsAuth();
        return Result.success(pubAuths);
    }
}
