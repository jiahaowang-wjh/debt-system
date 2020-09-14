package com.smart.bracelet.controller.assets;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusPropert;
import com.smart.bracelet.model.vo.assets.AssetsDebtBank;
import com.smart.bracelet.model.vo.assets.AssetsMyDebt;
import com.smart.bracelet.model.vo.debt.BusPropertVo;
import com.smart.bracelet.service.assets.BusPropertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/busPropertController/")
@Validated
public class BusPropertController {

    @Autowired
    private BusPropertService busPropertService;

    @RequestMapping("/deleteByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('assets:delete')")
    public Result deleteByPrimaryKey(@NotNull(message = "资产ID不能为空") Long propertId) throws CustomerException {
        int deleteByPrimaryKey = busPropertService.deleteByPrimaryKey(propertId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/insertSelective")
    @PreAuthorize("hasAnyAuthority('assets:add')")
    public Result insertSelective(@Valid BusPropert record) throws CustomerException {
        Long insertSelective = busPropertService.insertSelective(record);
        return Result.success(insertSelective + "");
    }

    @RequestMapping("/selectByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('assets:select')")
    public Result<BusPropert> selectByPrimaryKey(@NotNull(message = "资产ID不能为空") Long propertId) {
        BusPropert busPropert = busPropertService.selectByPrimaryKey(propertId);
        return Result.success(busPropert);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    @PreAuthorize("hasAnyAuthority('assets:update')")
    public Result updateByPrimaryKeySelective(@Valid BusPropertVo record) throws CustomerException {
        int updateByPrimaryKeySelective = busPropertService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/queryList")
    @PreAuthorize("hasAnyAuthority('assets:select')")
    public Result<List<BusPropert>> queryList() {
        List<BusPropert> busProperts = busPropertService.queryList();
        return Result.success(busProperts);
    }

    /**
     * 更新资产审批状态
     *
     * @param status
     * @param propertId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateStatus")
    @PreAuthorize("hasAnyAuthority('assets:update')")
    public Result updateStatus(@NotBlank(message = "状态不能为空") String status, @NotNull(message = "资产ID不能为空") Long propertId, String checkReason) throws CustomerException {
        int i = busPropertService.updateStatus(status, checkReason, propertId);
        return Result.success(i);
    }

    /**
     * 资产系统，我的债行
     *
     * @return
     */
    @RequestMapping("/querys")
    @PreAuthorize("hasAnyAuthority('assets:select')")
    public Result<PageInfo> querys(@NotNull(message = "页码不能为空") Integer pageNum,
                                   @NotNull(message = "当前显示条数不能为空") Integer pageSize,
                                   @Valid AssetsMyDebt assetsMyDebt ) {
        PageHelper.startPage(pageNum, pageSize);
        List<AssetsDebtBank> querys = busPropertService.querys(assetsMyDebt);
        PageInfo<AssetsDebtBank> assetsDebtBankPageInfo = new PageInfo<>(querys);
        return Result.success(assetsDebtBankPageInfo);
    }
}
