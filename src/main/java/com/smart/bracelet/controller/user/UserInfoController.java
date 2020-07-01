package com.smart.bracelet.controller.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.UserInfo;
import com.smart.bracelet.service.UserInfoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 用户信息表(UserInfo)表控制层
 *
 * @author junyunxiao
 * @since 2020-06-30 17:08:12
 */
@RestController
@RequestMapping("/api/userInfo/")
public class UserInfoController {
    /**
     * 服务对象
     */
    @Resource
    private UserInfoService userInfoService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PreAuthorize("hasAuthority('userInfo:selectOne')")
    @GetMapping("selectOne")
    public UserInfo selectOne(Long id) {
        return this.userInfoService.getById(id);
    }


    @RequestMapping("/addUserInfo")
    public Result addUserInfo(@Valid UserInfo userInfo) throws CustomerException {
        int insert = userInfoService.addUserInfo(userInfo);
        return Result.success(insert);
    }

}
