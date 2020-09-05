package com.smart.bracelet.controller.debt;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.po.debt.PubDebt;
import com.smart.bracelet.model.vo.debt.DebtAndRepAndCiviI;
import com.smart.bracelet.model.vo.debt.DebtInfoQuery;
import com.smart.bracelet.model.vo.debt.PubDebtInfo;
import com.smart.bracelet.model.vo.debt.PubDebtVo;
import com.smart.bracelet.service.debt.PubDebtService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
        return Result.success(insertSelective+"");
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
    public Result<List<DateAndDays>> selectDaysCount() {
        List<DateAndDays> dateAndDays = pubDebtService.selectDaysCount();
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
     * @param status
     * @param debtId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateStatus")
    public Result updateStatus(@NotBlank(message = "状态不能为空") String status, @NotNull(message = "解债信息Id不能为空")Long debtId,@NotBlank(message = "审核原因不能为空") String checkReason) throws CustomerException{
        int i = pubDebtService.updateStatus(status, debtId,checkReason);
        return Result.success(i);
    }

    /**
     * 页面解债信息展示
     */
    @RequestMapping("/selectDebtListShow")
    public Result<PageInfo> selectDebtListShow(@NotNull(message = "页码不能为空") Integer pageNum,
                                                         @NotNull(message = "当前显示条数不能为空") Integer pageSize,
                                               String debtNo,Long debtId){
        PageHelper.startPage(pageNum,pageSize);
        List<PubDebtInfo> pubDebtInfos = pubDebtService.selectDebtListShow(debtNo,debtId);
        PageInfo<PubDebtInfo> pubDebtInfoPageInfo = new PageInfo<>(pubDebtInfos);
        return Result.success(pubDebtInfoPageInfo);
    }


    /**
     * 解债信息填写更新展示
     */
    @RequestMapping("/selectDebtAndRepAndCiviI")
    public Result<List<DebtAndRepAndCiviI>> selectDebtAndRepAndCiviI(){
        List<DebtAndRepAndCiviI> debtAndRepAndCiviIS = pubDebtService.selectDebtAndRepAndCiviI();
        return Result.success(debtAndRepAndCiviIS);
    }

}
