package com.smart.bracelet.controller.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.user.PubAuth;
import com.smart.bracelet.model.vo.user.PubAuthVo;
import com.smart.bracelet.service.user.PubAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/pubAuthController/")
@Validated
public class PubAuthController {

    @Autowired
    private PubAuthService pubAuthService;

    /**
     * 权限信息新增
     * @param record
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid PubAuth record) throws CustomerException{
        int insertSelective = pubAuthService.insertSelective(record);
        return Result.success(insertSelective);
    }

    /**
     * 通过Id删除权限
     * @param authId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "权限Id不能为空") Long authId) throws CustomerException{
        int deleteByPrimaryKey = pubAuthService.deleteByPrimaryKey(authId);
        return Result.success(deleteByPrimaryKey);
    }

    /**
     * 修改权限信息
     * @param record
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid PubAuthVo record) throws CustomerException{
        int updateByPrimaryKeySelective = pubAuthService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    /**
     * 通过Id查询权限信息
     * @param authId
     * @return
     */
    @RequestMapping("/selectByPrimaryKey")
    public Result<PubAuth> selectByPrimaryKey(@NotNull(message = "权限Id不能为空") Long authId){
        PubAuth pubAuth = pubAuthService.selectByPrimaryKey(authId);
        return Result.success(pubAuth);
    }

}
