package com.smart.bracelet.controller.debt;


import cn.hutool.json.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusCivil;
import com.smart.bracelet.model.po.debt.BusGuarantee;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.debt.*;
import com.smart.bracelet.service.debt.BusCivilService;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/api/busCivilController/")
@Validated
public class BusCivilController {

    @Autowired
    private BusCivilService busCivilService;

    @RequestMapping("/insertSelective")
    @PreAuthorize("hasAnyAuthority('debt:add')")
    public Result insertSelective(@Valid BusCivil record) throws CustomerException {
        Long insertSelective = busCivilService.insertSelective(record);
        return Result.success(insertSelective + "");
    }

    @RequestMapping("/deleteByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('debt:delete')")
    public Result deleteByPrimaryKey(@NotNull(message = "民事调解Id不能为空") Long civilId) throws CustomerException {
        int deleteByPrimaryKey = busCivilService.deleteByPrimaryKey(civilId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    @PreAuthorize("hasAnyAuthority('debt:update')")
    public Result updateByPrimaryKeySelective(@Valid BusCivilVo record) throws CustomerException {
        int updateByPrimaryKeySelective = busCivilService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('debt:select')")
    public Result<BusCivil> selectByPrimaryKey(@NotNull(message = "民事调解Id不能为空") Long civilId) {
        BusCivil busCivil = busCivilService.selectByPrimaryKey(civilId);
        return Result.success(busCivil);
    }

    /**
     * 按照日期查询每日报备数量
     *
     * @return
     */
    @RequestMapping("/selectDaysCount")
    @PreAuthorize("hasAnyAuthority('debt:select')")
    public Result<List<DateAndDays>> selectDaysCount() {
        List<DateAndDays> dateAndDays = busCivilService.selectDaysCount();
        return Result.success(dateAndDays);
    }


    /**
     * 查询所有民事调解信息
     *
     * @return
     */
    @RequestMapping("/queryList")
    @PreAuthorize("hasAnyAuthority('debt:select')")
    public Result<List<BusCivil>> queryList() {
        List<BusCivil> busCivils = busCivilService.queryList();
        return Result.success(busCivils);
    }

    /**
     * 更新民事调解状态
     *
     * @param status
     * @param civilId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateStatus")
    @PreAuthorize("hasAnyAuthority('debt:update')")
    public Result updateStatus(@NotBlank(message = "民事调解状态不能为空") String status, @NotNull(message = "民事调解Id不能为空") Long civilId, String checkReason) throws CustomerException {
        int i = busCivilService.updateStatus(status, civilId, checkReason);
        return Result.success(i);
    }

    /**
     * 页面展示民事调解信息
     */
    @RequestMapping("/selectBusList")
    @PreAuthorize("hasAnyAuthority('debt:select')")
    public Result<PageInfo> selectBusList(@NotNull(message = "页码不能为空") Integer pageNum,
                                          @NotNull(message = "当前显示条数不能为空") Integer pageSize,
                                          @Valid DebtInfoQuery debtInfoQuery) {
        PageHelper.startPage(pageNum, pageSize);
        if (!StringUtils.isBlank(debtInfoQuery.getBeginDate())) {
            debtInfoQuery.setBeginDate(debtInfoQuery.getBeginDate() + " 00:00:00");
        }
        if (!StringUtils.isBlank(debtInfoQuery.getEndDate())) {
            debtInfoQuery.setEndDate(debtInfoQuery.getEndDate() + " 23:59:00");
        }
        List<BusCivilInfo> busCivilInfos = busCivilService.selectBusList(debtInfoQuery);
        PageInfo<BusCivilInfo> busCivilInfoPageInfo = new PageInfo<>(busCivilInfos);
        return Result.success(busCivilInfoPageInfo);
    }

    /**
     * 民事调解信息填写页面更新信息
     */
    @RequestMapping("/selectCiviIAndRepShow")
    @PreAuthorize("hasAnyAuthority('debt:select')")
    public Result<List<CiviIAndRepShow>> selectCiviIAndRepShow() {
        List<CiviIAndRepShow> civiIAndRepShows = busCivilService.selectCiviIAndRepShow();
        return Result.success(civiIAndRepShows);
    }

    /**
     * 民事调解身份验证
     *
     * @param relativePerId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/verification")
    public Result verification(@NotNull(message = "相对人ID不能为空") Long relativePerId) throws CustomerException {
        Boolean verification = busCivilService.verification(relativePerId);
        return Result.success(verification);
    }

    /**
     * 尽调协议初始化
     */
    @RequestMapping("/initialize")
    @PreAuthorize("hasAnyAuthority('debt:select')")
    public Result<AgreementInfoShow> initialize(@NotNull(message = "报备ID不能为空") Long reportId) {
        AgreementInfoShow initialize = busCivilService.initialize(reportId);
        return Result.success(initialize);
    }

    /**
     * 策划方案服务协议初始化
     */
    @RequestMapping("/initializePlan")
    @PreAuthorize("hasAnyAuthority('debt:select')")
    public Result<PlanServiceInfo> initializePlan(@NotNull(message = "报备ID不能为空") Long reportId) throws CustomerException {
        PlanServiceInfo initialize = busCivilService.initializePlan(reportId);
        return Result.success(initialize);
    }

    /**
     * 通过报备ID查询民事调解协议
     *
     * @param reportId
     * @return
     */
    @RequestMapping("/selectByReportId")
    @PreAuthorize("hasAnyAuthority('debt:select')")
    public Result<List<BusCivil>> selectByReportId(@NotNull(message = "报备Id不能为空") Long reportId) {
        List<BusCivil> busCivils = busCivilService.selectByReportId(reportId);
        return Result.success(busCivils);
    }


    /**
     * 民事调解书
     */
    @RequestMapping("/selectCivi")
    @PreAuthorize("hasAnyAuthority('debt:select')")
    public Result<List<CivilAndPseronInfo>> selectCivi(@NotNull(message = "报备ID不能为空") Long reportId) {
        List<CivilAndPseronInfo> civilAndPseronInfos = busCivilService.selectCivi(reportId);
        return Result.success(civilAndPseronInfos);
    }


}
