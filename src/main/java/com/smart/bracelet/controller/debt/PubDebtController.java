package com.smart.bracelet.controller.debt;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.AssService;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.po.debt.PubDebt;
import com.smart.bracelet.model.vo.debt.*;
import com.smart.bracelet.service.debt.PubDebtService;
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
@RequestMapping("/api/pubDebtController/")
@Validated
public class PubDebtController {

    @Autowired
    private PubDebtService pubDebtService;

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid PubDebt record) throws CustomerException {
        Long insertSelective = pubDebtService.insertSelective(record);
        return Result.success(insertSelective + "");
    }


    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "解债信息Id不能为空") Long debtId) throws CustomerException {
        int deleteByPrimaryKey = pubDebtService.deleteByPrimaryKey(debtId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid PubDebtVo record) throws CustomerException {
        int updateByPrimaryKeySelective = pubDebtService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<PubDebt> selectByPrimaryKey(@NotNull(message = "解债信息Id不能为空") Long debtId) {
        PubDebt pubDebt = pubDebtService.selectByPrimaryKey(debtId);
        return Result.success(pubDebt);
    }

    /**
     * 按照日期查询每日解债数量
     */
    @RequestMapping("/selectDaysCount")
    public Result<List<DateAndDays>> selectDaysCount(@NotBlank(message = "公司类型不能为空") String type,@NotNull(message = "公司ID不能为空") Long comId) {
        List<DateAndDays> dateAndDays = pubDebtService.selectDaysCount(type,comId);
        return Result.success(dateAndDays);
    }

    /**
     * 查询所有解债信息
     *
     * @return
     */
    @RequestMapping("/queryList")
    public Result queryList() {
        List<PubDebt> pubDebts = pubDebtService.queryList();
        return Result.success(pubDebts);
    }

    /**
     * 更新解债审批状态
     *
     * @param status
     * @param debtId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateStatus")
    public Result updateStatus(@NotBlank(message = "状态不能为空") String status, @NotNull(message = "解债信息Id不能为空") Long debtId, String checkReason) throws CustomerException {
        int i = pubDebtService.updateStatus(status, debtId, checkReason);
        return Result.success(i);
    }

    /**
     * 页面解债信息展示
     */
    @RequestMapping("/selectDebtListShow")
    public Result<PageInfo> selectDebtListShow(@NotNull(message = "页码不能为空") Integer pageNum,
                                               @NotNull(message = "当前显示条数不能为空") Integer pageSize,
                                               @Valid QueryDebtVo queryDebtVo) {
        if (!StringUtils.isBlank(queryDebtVo.getBeginDate())) {
            queryDebtVo.setBeginDate(queryDebtVo.getBeginDate() + " 00:00:00");
        }
        if (!StringUtils.isBlank(queryDebtVo.getEndDate())) {
            queryDebtVo.setEndDate(queryDebtVo.getEndDate() + " 23:59:00");
        }

        PageHelper.startPage(pageNum, pageSize);
        List<PubDebtInfo> pubDebtInfos = pubDebtService.selectDebtListShow(queryDebtVo);
        PageInfo<PubDebtInfo> pubDebtInfoPageInfo = new PageInfo<>(pubDebtInfos);
        return Result.success(pubDebtInfoPageInfo);
    }


    /**
     * 解债信息填写更新展示
     */
    @RequestMapping("/selectDebtAndRepAndCiviI")
    public Result<List<DebtAndRepAndCiviI>> selectDebtAndRepAndCiviI() {
        List<DebtAndRepAndCiviI> debtAndRepAndCiviIS = pubDebtService.selectDebtAndRepAndCiviI();
        return Result.success(debtAndRepAndCiviIS);
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
     * 查询金额
     *
     * @param relativePerId
     * @return
     */
    @RequestMapping("/selectMoney")
    public Result<DebtMoney> selectMoney(@NotNull(message = "相对人id不能为空") Long relativePerId) {
        DebtMoney debtMoney = pubDebtService.selectMoney(relativePerId);
        return Result.success(debtMoney);
    }


    /**
     * 解债页面展示
     */
    @RequestMapping("/selectByReportIds")
    public Result<List<PubDebtInfo>> selectByReportIds(@NotNull(message = "报备ID不能为空") Long reportId) {
        List<PubDebtInfo> pubDebtInfos = pubDebtService.selectByReportIds(reportId);
        return Result.success(pubDebtInfos);
    }

    /**
     * 新增咨询服务协议
     */
    @RequestMapping("/insertService")
    public Result updateService(@Valid AssService assService) throws CustomerException {
        int a = pubDebtService.updateService(assService);
        return Result.success(a);
    }

    /**
     * 查询策划方案协议
     *
     * @param debtId
     * @return
     */
    @RequestMapping("/selectAssService")
    public Result<AssService> selectAssService(@NotNull Long debtId) {
        AssService assService = pubDebtService.selectAssService(debtId);
        return Result.success(assService);
    }


}
