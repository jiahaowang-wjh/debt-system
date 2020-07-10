package com.smart.bracelet.controller.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.user.PubDoc;
import com.smart.bracelet.model.vo.user.PubDocVo;
import com.smart.bracelet.service.user.PubDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 文档管理
 */

@RestController
@RequestMapping("/api/pubDocController/")
@Validated
public class PubDocController {

    @Autowired
    private PubDocService pubDocService;

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid PubDoc record) throws CustomerException{
        int insertSelective = pubDocService.insertSelective(record);
        return Result.success(insertSelective);
    }
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "文档ID不能为空") Long docId) throws CustomerException{
        int deleteByPrimaryKey = pubDocService.deleteByPrimaryKey(docId);
        return Result.success(deleteByPrimaryKey);
    }
    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid PubDocVo record) throws CustomerException{
        int updateByPrimaryKeySelective = pubDocService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }
    @RequestMapping("/selectByPrimaryKey")
    public Result<PubDoc> selectByPrimaryKey(@NotNull(message = "文档ID不能为空") Long docId){
        PubDoc pubDoc = pubDocService.selectByPrimaryKey(docId);
        return Result.success(pubDoc);
    }

}
