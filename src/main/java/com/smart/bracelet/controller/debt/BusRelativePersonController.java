package com.smart.bracelet.controller.debt;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.vo.debt.*;
import com.smart.bracelet.service.debt.BusRelativePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/busRelativePersonController/")
@Validated
public class BusRelativePersonController {

    @Autowired
    private BusRelativePersonService busRelativePersonService;

    /**
     * 新增私人相对人信息
     *
     * @param
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/insertPrivateSelective")
    @PreAuthorize("hasAnyAuthority('debt:add')")
    public Result insertPrivateSelective(@Valid BusRelativePersonPrivateVo busRelativePersonPrivateVo) throws CustomerException {
        Long insertPrivate = busRelativePersonService.insertPrivate(busRelativePersonPrivateVo);
        return Result.success(insertPrivate + "");
    }


    /**
     * 新增企业相对人信息
     *
     * @param
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/insertEnterprise")
    @PreAuthorize("hasAnyAuthority('debt:add')")
    public Result insertEnterprise(@Valid BusRelativePersonEnterpriseVo busRelativePersonEnterpriseVo) throws CustomerException {
        Long insertPrivate = busRelativePersonService.insertEnterprise(busRelativePersonEnterpriseVo);
        return Result.success(insertPrivate + "");
    }

    /**
     * 新增银行相对人信息
     *
     * @param
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/insertBank")
    @PreAuthorize("hasAnyAuthority('debt:add')")
    public Result insertBank(@Valid BusRelativePersonBankVo busRelativePersonBankVo) throws CustomerException {
        Long insertPrivate = busRelativePersonService.insertBank(busRelativePersonBankVo);
        return Result.success(insertPrivate + "");
    }


    /**
     * 通过ID删除相对人信息
     *
     * @param relativePerId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/deleteByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('debt:delete')")
    public Result deleteByPrimaryKey(@NotNull(message = "相对人信息ID不能为空") Long relativePerId) throws CustomerException {
        int deleteByPrimaryKey = busRelativePersonService.deleteByPrimaryKey(relativePerId);
        return Result.success(deleteByPrimaryKey);
    }

    /**
     * 更新私人相对人信息
     *
     * @param busRelativePersonPrivateUpdateVo
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updatePrivate")
    @PreAuthorize("hasAnyAuthority('debt:update')")
    public Result updatePrivate(@Valid BusRelativePersonPrivateUpdateVo busRelativePersonPrivateUpdateVo) throws CustomerException {
        int updatePrivate = busRelativePersonService.updatePrivate(busRelativePersonPrivateUpdateVo);
        return Result.success(updatePrivate);
    }

    /**
     * 更新企业相对人信息
     *
     * @param busRelativePersonEnterpriseUpdateVo
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateEnterprise")
    @PreAuthorize("hasAnyAuthority('debt:update')")
    public Result updateEnterprise(@Valid BusRelativePersonEnterpriseUpdateVo busRelativePersonEnterpriseUpdateVo) throws CustomerException {
        int updateEnterprise = busRelativePersonService.updateEnterprise(busRelativePersonEnterpriseUpdateVo);
        return Result.success(updateEnterprise);
    }

    /**
     * 更新银行相对人信息
     *
     * @param busRelativePersonBankUpdateVo
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateBank")
    @PreAuthorize("hasAnyAuthority('debt:update')")
    public Result updateBank(@Valid BusRelativePersonBankUpdateVo busRelativePersonBankUpdateVo) throws CustomerException {
        int updateBank = busRelativePersonService.updateBank(busRelativePersonBankUpdateVo);
        return Result.success(updateBank);
    }

    /**
     * 通过Id查询相对人信息
     *
     * @param relativePerId
     * @return
     */
    @RequestMapping("/selectByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('debt:select')")
    public Result<BusRelativePersonListVo> selectByPrimaryKey(@NotNull(message = "相对人信息ID不能为空") Long relativePerId) {
        BusRelativePersonListVo busRelativePerson = busRelativePersonService.selectByPrimaryKey(relativePerId);
        return Result.success(busRelativePerson);
    }

    /**
     * 查询所有相对人信息
     *
     * @return
     */
    @RequestMapping("/queryList")
    @PreAuthorize("hasAnyAuthority('debt:select')")
    public Result<List<BusRelativePersonListVo>> queryList() {
        List<BusRelativePersonListVo> listVos = busRelativePersonService.queryListVo();
        return Result.success(listVos);
    }

    /**
     * 根据报备ID查询相对人信息并验证符合民事调解关系
     */
    @RequestMapping("/selectByreportId")
    @PreAuthorize("hasAnyAuthority('debt:select')")
    public Result<List<BusRelativePersonListVo>> selectByreportId(@NotNull(message = "报备ID不能为空") Long reportId) throws CustomerException {
        List<BusRelativePersonListVo> busRelativePeople = busRelativePersonService.selectByreportId(reportId);
        return Result.success(busRelativePeople);
    }

    /**
     * 通过相对人ID查询相对人债事人信息
     *
     * @param relativePerId
     * @return
     */
    @RequestMapping("/selectByRelativePerId")
    @PreAuthorize("hasAnyAuthority('debt:select')")
    public Result<ReportAndRelativePersonShow> selectByRelativePerId(@NotNull(message = "相对人不能为空") Long relativePerId) throws CustomerException {
        ReportAndRelativePersonShow reportAndRelativePerson = busRelativePersonService.selectByRelativePerId(relativePerId);
        return Result.success(reportAndRelativePerson);
    }

    /**
     * 根据报备ID查询相对人信息
     */
    @RequestMapping("/selectByRepId")
    @PreAuthorize("hasAnyAuthority('debt:select')")
    public Result<List<BusRelativePersonListVo>> selectByRepId(@NotNull(message = "报备ID不能为空") Long reportId) throws CustomerException {
        List<BusRelativePersonListVo> listVos = busRelativePersonService.selectByRepId(reportId);
        return Result.success(listVos);
    }

    /**
     * 辅助下载财务
     */
    @RequestMapping("/selectDow")
    @PreAuthorize("hasAnyAuthority('debt:select')")
    public Result<PageInfo> selectDow(@NotNull(message = "页码不能为空") Integer pageNum,
                                      @NotNull(message = "当前显示条数不能为空") Integer pageSize,
                                      String debtName, String time) throws ParseException {
        PageHelper.startPage(pageNum, pageSize);
        List<AuxiliaryDownload> auxiliaryDownloads = busRelativePersonService.selectDow(debtName, time);
        PageInfo<AuxiliaryDownload> auxiliaryDownloadPageInfo = new PageInfo<>(auxiliaryDownloads);
        return Result.success(auxiliaryDownloadPageInfo);
    }

    /**
     * 根据报备ID查询相对人信息并验证是否符合解债申请
     */
    @RequestMapping("/selectByreportIdAndDebt")
    @PreAuthorize("hasAnyAuthority('debt:select')")
    public Result<List<BusRelativePersonListVo>> selectByreportIdAndDebt(@NotNull(message = "报备ID不能为空") Long reportId) throws CustomerException {
        List<BusRelativePersonListVo> listVos = busRelativePersonService.selectByreportIdAndDebt(reportId);
        return Result.success(listVos);
    }

    /**
     * 辅助下载债务
     */
    @RequestMapping("/selectDebtDow")
    public Result<PageInfo> selectDebtDow(
            @NotNull(message = "页码不能为空") Integer pageNum,
            @NotNull(message = "当前显示条数不能为空") Integer pageSize,
            String debtName, String time) {
        PageHelper.startPage(pageNum,pageSize);
        List<DowLod> dowLods = busRelativePersonService.selectDebtDow(debtName, time);
        PageInfo<DowLod> dowLodPageInfo = new PageInfo<>(dowLods);
        return Result.success(dowLodPageInfo);
    }


    /**
     * 新增咨询服务协议
     */



}
