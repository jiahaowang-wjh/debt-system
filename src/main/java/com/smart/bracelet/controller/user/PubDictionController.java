package com.smart.bracelet.controller.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.user.PubDiction;
import com.smart.bracelet.model.vo.user.PubDictionVo;
import com.smart.bracelet.service.user.PubDictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 字典管理
 */
@RestController
@RequestMapping("/api/pubDictionController/")
@Validated
public class PubDictionController {

    @Autowired
    private PubDictionService pubDictionService;

    /**
     * 新增字典信息
     *
     * @param pubDiction
     * @return
     */
    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid PubDiction pubDiction) throws CustomerException {
        int insertSelective = pubDictionService.insertSelective(pubDiction);
        return Result.success(insertSelective);
    }

    /**
     * 通过ID删除字典信息
     *
     * @param dictionId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "字典ID不能为空") Long dictionId) throws CustomerException {
        int deleteByPrimaryKey = pubDictionService.deleteByPrimaryKey(dictionId);
        return Result.success(deleteByPrimaryKey);
    }

    /**
     * 更新字典
     * @param record
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid PubDictionVo record) throws CustomerException{
        int updateByPrimaryKeySelective = pubDictionService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    /**
     * 通过Id查询字典信息
     * @param dictionId
     * @return
     */
    @RequestMapping("/selectByPrimaryKey")
    public Result<PubDiction> selectByPrimaryKey(@NotNull(message = "字典信息Id不能为空") Long dictionId){
        PubDiction pubDiction = pubDictionService.selectByPrimaryKey(dictionId);
        return Result.success(pubDiction);
    }

}
