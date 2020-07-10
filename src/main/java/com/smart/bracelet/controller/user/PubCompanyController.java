package com.smart.bracelet.controller.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.user.PubCompany;
import com.smart.bracelet.model.vo.user.PubCompanyVo;
import com.smart.bracelet.service.user.PubCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/pubCompanyController/")
@Validated
public class PubCompanyController {

    @Autowired
    private PubCompanyService pubCompanyService;

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid PubCompany record) throws CustomerException{
        int insertSelective = pubCompanyService.insertSelective(record);
        return Result.success(insertSelective);
    }

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "公司ID不能为空") Long companyId) throws CustomerException{
        int deleteByPrimaryKey = pubCompanyService.deleteByPrimaryKey(companyId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid PubCompanyVo record) throws CustomerException{
        int updateByPrimaryKeySelective = pubCompanyService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<PubCompany> selectByPrimaryKey(@NotNull(message = "公司Id不能为空") Long companyId){
        PubCompany pubCompany = pubCompanyService.selectByPrimaryKey(companyId);
        return Result.success(pubCompany);
    }
}
