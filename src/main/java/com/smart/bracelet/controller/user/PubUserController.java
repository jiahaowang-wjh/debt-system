package com.smart.bracelet.controller.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.user.PubMenu;
import com.smart.bracelet.model.po.user.PubUser;
import com.smart.bracelet.model.vo.user.PubUserVo;
import com.smart.bracelet.service.user.PubUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 用户管理
 */
@RestController
@RequestMapping("/api/pubUser/")
@Validated
public class PubUserController {

    /**
     * 服务对象
     */
    @Resource
    private PubUserService userInfoService;

    /**
     * 新增用户信息
     * @param pubUser
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/addPubUser")
    public Result addPubUser(@Valid PubUser pubUser) throws CustomerException {
        int insert = userInfoService.insertSelective(pubUser);
        return Result.success(insert);
    }

    /**
     * 修改用户信息
     * @param record
     * @return
     */
    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid PubUserVo record) throws CustomerException{
        int updateByPrimaryKeySelective = userInfoService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }



    /**
     * 通过ID删除用户信息
     * @param userId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "用户Id不能为空") Long userId) throws CustomerException {
        int deleteByPrimaryKey = userInfoService.deleteByPrimaryKey(userId);
        return Result.success(deleteByPrimaryKey);
    }

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/queryUserList")
    public Result<List<PubUser>> queryUserList(){
        List<PubUser> pubUsers = userInfoService.queryUserList();
        return Result.success(pubUsers);
    }

    /**
     * 通过Id查询用户信息
     * @param userId
     * @return
     */
    @RequestMapping("/selectByPrimaryKey")
    public Result<PubUser> selectByPrimaryKey(@NotNull(message = "用户Id不能为空")Long userId){
        PubUser pubUser = userInfoService.selectByPrimaryKey(userId);
        return Result.success(pubUser);
    }

    /**
     * 通过用户Id查询菜单信息
     * @param userId
     * @return
     */
    @RequestMapping("/selectMenuByUserId")
    public Result<List<PubMenu>> selectMenuByUserId(@NotNull(message = "用户Id不能为空") Long userId){
        List<PubMenu> pubMenus = userInfoService.selectMenuByUserId(userId);
        return Result.success(pubMenus);
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping("/updatePwd")
    public Result updatePwd(@NotBlank(message = "旧密码不能为空") String outPwd,
                            @NotBlank(message = "新密码不能为空")String newPwdA,
                            @NotBlank(message = "重复新密码不能为空")String newPwdB,
                            @NotNull(message = "用户Id不能为空") Long personId ) throws CustomerException {
        int updateUserPwd = userInfoService.updateUserPwd(outPwd, newPwdA,newPwdB, personId);
        return Result.success(updateUserPwd);
    }

    /**
     * 批量删除用户
     * @return
     */
    @RequestMapping("/delUserList")
    public Result delUserList(@NotNull(message = "用户ID不能为空") Long[] userIds) throws CustomerException {
        int delUserList = userInfoService.delUserList(userIds);
        return Result.success(delUserList);
    }
}
