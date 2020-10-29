package com.smart.bracelet.controller.debt;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.po.debt.PubDebt;
import com.smart.bracelet.model.vo.debt.*;
import com.smart.bracelet.service.debt.PubDebtService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/pubDebtController/")
@Validated
public class PubDebtController {

    @Autowired
    private PubDebtService pubDebtService;

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "解债ID不能为空") Long debtId) throws CustomerException {
        int a = pubDebtService.deleteByPrimaryKey(debtId);
        return Result.success(a);
    }

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid PubDebt record) throws CustomerException {
        Long aLong = pubDebtService.insertSelective(record);
        return Result.success(aLong+"");
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<PubDebt> selectByPrimaryKey(@NotNull(message = "解债ID不能为空")Long debtId) {
        PubDebt pubDebt = pubDebtService.selectByPrimaryKey(debtId);
        return Result.success(pubDebt);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid PubDebtVo record) throws CustomerException {
        int i = pubDebtService.updateByPrimaryKeySelective(record);
        return Result.success(i);
    }
    /**
     * 按照日期查询每日解债数量
     * @return
     */
    @RequestMapping("/selectDaysCount")
    public Result<List<DateAndDays>> selectDaysCount(@NotBlank(message = "公司类型不能为空") String type, @NotNull(message = "公司ID不能为空") Long comId){
        List<DateAndDays> dateAndDays = pubDebtService.selectDaysCount(type, comId);
        return Result.success(dateAndDays);
    }


    /**
     * 更新审核状态
     * @param status
     * @param debtId
     * @return
     */
    @RequestMapping("/updateStatus")
    public Result updateStatus(@NotBlank(message = "状态不能为空") String status,@NotNull(message = "解债ID不能为空") Long debtId,String checkReason) throws CustomerException{
        int i = pubDebtService.updateStatus(status, debtId, checkReason);
        return Result.success(i);
    }


    /**
     * 页面解债信息展示
     */
    @RequestMapping("/selectDebtListShow")
    public Result<PageInfo> selectDebtListShow(@NotNull(message = "页码不能为空") Integer pageNum,
                                                        @NotNull(message = "当前显示条数不能为空") Integer pageSize,
                                               @Valid DebtInfoQuery debtInfoQuery){
        if (!StringUtils.isBlank(debtInfoQuery.getBeginDate()) && !debtInfoQuery.getBeginDate().equals("null")) {
            debtInfoQuery.setBeginDate(debtInfoQuery.getBeginDate() + " 00:00:00");
        }else{
            debtInfoQuery.setBeginDate(null);
        }
        if (!StringUtils.isBlank(debtInfoQuery.getEndDate()) && !debtInfoQuery.getEndDate().equals("null")) {
            debtInfoQuery.setEndDate(debtInfoQuery.getEndDate() + " 23:59:00");
        }else{
            debtInfoQuery.setEndDate(null);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<PubDebtInfo> pubDebtInfos = pubDebtService.selectDebtListShow(debtInfoQuery);
        PageInfo<PubDebtInfo> pubDebtInfoPageInfo = new PageInfo<>(pubDebtInfos);
        return Result.success(pubDebtInfoPageInfo);
    }

    /**
     * 解债页面列表（关系绑定）
     */
    @RequestMapping("/selectByReportIds")
    public Result<List<PubDebtInfo>> selectByReportIds(@NotNull(message = "报备ID不能为空") Long reportId){
        List<PubDebtInfo> pubDebtInfos = pubDebtService.selectByReportIds(reportId);
        return Result.success(pubDebtInfos);
    }

    /**
     * 通过报备Id查询解债信息
     */
    @RequestMapping("/selectByreportId")
    public Result<List<PubDebt>> selectByreportId(@NotNull(message = "报备Id不能为空") Long reportId) {
        List<PubDebt> pubDebts = pubDebtService.selectByreportId(reportId);
        return Result.success(pubDebts);
    }


    /**
     * 策划方案服务协议初始化
     */
    @RequestMapping("/initializePlan")
    public Result<PlanServiceInfo> initializePlan(@NotNull(message = "解债ID不能为空") Long debtId,@NotNull(message = "公司ID不能为空") Long comId) throws CustomerException {
        PlanServiceInfo initialize = pubDebtService.initializePlan(debtId,comId);
        return Result.success(initialize);
    }

    /**
     * 策划方案新增
     * @param matters
     * @param serviceNo
     * @param servicePrincipal
     * @param serviceInterest
     * @param contractDate
     * @return
     */
    @RequestMapping("/insertPlanInfo")
   public Result updatePlanInfo(@NotBlank(message = "甲方手选身份不能为空") String matters, @NotBlank(message = "服务编号不能为空")String serviceNo, @NotNull(message = "本金不能为空") Float servicePrincipal, @NotNull(message = "利息不能为空")Float serviceInterest, @NotNull(message = "签约日期不能为空") @DateTimeFormat(pattern = "yyyy-MM-dd") Date contractDate, @NotNull(message = "解债ID不能为空")Long debtId) throws CustomerException{
        int i = pubDebtService.updatePlanInfo(matters, serviceNo, servicePrincipal, serviceInterest, contractDate, debtId);
        return Result.success(i);
   }


    /**
     * 查询累计解债信息
     * @param reportId
     * @return
     */
    @RequestMapping("/selectMoney")
    public Result<PubDebt> selectMoney(@NotNull(message = "报备Id不能为空") Long reportId){
        PubDebt pubDebt = pubDebtService.selectMoney(reportId);
        return Result.success(pubDebt);
    }

}
