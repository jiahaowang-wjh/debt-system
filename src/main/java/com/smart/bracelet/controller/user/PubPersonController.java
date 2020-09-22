package com.smart.bracelet.controller.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.user.PubPerson;
import com.smart.bracelet.model.po.user.PubUser;
import com.smart.bracelet.model.vo.user.PubPersonVo;
import com.smart.bracelet.service.user.PubPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 人员信息
 */
@RestController
@RequestMapping("/api/pubPersonController/")
@Validated
public class PubPersonController {

    @Autowired
    private PubPersonService pubPersonService;


    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid PubPerson record) throws CustomerException {
        int insertSelective = pubPersonService.insertSelective(record);
        return Result.success(insertSelective);
    }

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "人员ID不能为空") Long personId) throws CustomerException {
        int deleteByPrimaryKey = pubPersonService.deleteByPrimaryKey(personId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid PubPersonVo record) throws CustomerException {
        int updateByPrimaryKeySelective = pubPersonService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<PubPerson> selectByPrimaryKey(@NotNull(message = "人员ID不能为空") Long personId) {
        PubPerson pubPerson = pubPersonService.selectByPrimaryKey(personId);
        return Result.success(pubPerson);
    }

    /**
     * 查询推荐人
     */
    @RequestMapping("/selectByType")
    public Result<List<PubPerson>> selectByType(@NotBlank(message = "类型不能为空") String personType) {
        List<PubPerson> pubUsers = pubPersonService.selectByType(personType);
        return Result.success(pubUsers);
    }
}
