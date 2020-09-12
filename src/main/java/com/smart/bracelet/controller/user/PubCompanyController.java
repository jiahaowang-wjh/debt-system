package com.smart.bracelet.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.user.PubCompany;
import com.smart.bracelet.model.vo.user.PubCompanyVo;
import com.smart.bracelet.service.user.PubCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/pubCompanyController/")
@Validated
public class PubCompanyController {

    @Autowired
    private PubCompanyService pubCompanyService;

    @RequestMapping("/insertSelective")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public Result insertSelective(@Valid PubCompany record) throws CustomerException {
        int insertSelective = pubCompanyService.insertSelective(record);
        return Result.success(insertSelective);
    }

    @RequestMapping("/deleteByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('user:select')")
    public Result deleteByPrimaryKey(@NotNull(message = "公司ID不能为空") Long companyId) throws CustomerException {
        int deleteByPrimaryKey = pubCompanyService.deleteByPrimaryKey(companyId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    @PreAuthorize("hasAnyAuthority('user:update')")
    public Result updateByPrimaryKeySelective(@Valid PubCompanyVo record) throws CustomerException {
        int updateByPrimaryKeySelective = pubCompanyService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('user:select')")
    public Result<PubCompany> selectByPrimaryKey(@NotNull(message = "公司Id不能为空") Long companyId) {
        PubCompany pubCompany = pubCompanyService.selectByPrimaryKey(companyId);
        return Result.success(pubCompany);
    }

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/queryListPage")
    @PreAuthorize("hasAnyAuthority('user:select')")
    public Result<PageInfo> queryListPage(@NotNull(message = "页码不能为空") Integer pageNum, @NotNull(message = "当前显示条数不能为空") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PubCompany> pubCompanies = pubCompanyService.queryList();
        PageInfo<PubCompany> pubCompanyPageInfo = new PageInfo<>(pubCompanies);
        return Result.success(pubCompanyPageInfo);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @RequestMapping("/queryList")
    @PreAuthorize("hasAnyAuthority('user:select')")
    public Result<List<PubCompany>> queryList() {
        List<PubCompany> pubCompanies = pubCompanyService.queryList();
        return Result.success(pubCompanies);
    }


}
