package com.smart.bracelet.controller.debt;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.debt.*;
import com.smart.bracelet.service.debt.BusReportService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 报备信息表现层
 */
@RestController
@RequestMapping("/api/busReportController/")
@Validated
public class BusReportController {

    @Autowired
    private BusReportService busReportService;


    /**
     * 新增私人报备信息
     *
     * @param
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/insertPrivateSelective")
    public Result insertPrivateSelective(@Valid BusPrivateReport busPrivateReport) throws CustomerException {
        int insertPrivateSelective = busReportService.insertPrivateSelective(busPrivateReport);
        return Result.success(insertPrivateSelective);
    }

    /**
     * 新增企业报备信息
     *
     * @param
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/insertEterpriseSelective")
    public Result insertEterpriseSelective(@Valid BusEterpriseReport busEterpriseReport) throws CustomerException {
        int insertEterpriseSelective = busReportService.insertEterpriseSelective(busEterpriseReport);
        return Result.success(insertEterpriseSelective);
    }

    /**
     * 新增银行报备信息
     *
     * @param
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/insertBankSelective")
    public Result insertBankSelective(@Valid BusBankReport busBankReport) throws CustomerException {
        int insertBankSelective = busReportService.insertBankSelective(busBankReport);
        return Result.success(insertBankSelective);
    }

    /**
     * 通过Id删除报备信息
     *
     * @param reportId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "报备信息Id不能为空") Long reportId) throws CustomerException {
        int deleteByPrimaryKey = busReportService.deleteByPrimaryKey(reportId);
        return Result.success(deleteByPrimaryKey);
    }

    /**
     * 更新个人报备信息
     *
     * @param busPrivateReportVo
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updatePrivateSelective")
    public Result updatePrivateSelective(@Valid BusPrivateReportVo busPrivateReportVo) throws CustomerException {
        int updatePrivateSelective = busReportService.updatePrivateSelective(busPrivateReportVo);
        return Result.success(updatePrivateSelective);
    }


    /**
     * 更新个人报备信息
     *
     * @param busPrivateReportVo
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateEterpriseSelective")
    public Result updateEterpriseSelective(@Valid BusEterpriseReportVo busPrivateReportVo) throws CustomerException {
        int updatePrivateSelective = busReportService.updateEterpriseSelective(busPrivateReportVo);
        return Result.success(updatePrivateSelective);
    }

    /**
     * 更新个人报备信息
     *
     * @param busPrivateReportVo
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateBankSelective")
    public Result updateBankSelective(@Valid BusBankReportVo busPrivateReportVo) throws CustomerException {
        int updatePrivateSelective = busReportService.updateBankSelective(busPrivateReportVo);
        return Result.success(updatePrivateSelective);
    }


    /**
     * 通过Id查询报备信息
     *
     * @param reportId
     * @return
     */
    @RequestMapping("/selectByPrimaryKey")
    public Result<BusReportListVo> selectByPrimaryKey(@NotNull(message = "报备信息Id不能为空") Long reportId) throws CustomerException {
        BusReportListVo busReportListVo = busReportService.selectByPrimaryKey(reportId);
        return Result.success(busReportListVo);
    }

    /**
     * 查询所有报备信息
     *
     * @return
     */
    @RequestMapping("/queryBusReport")
    public Result<List<BusReportListVo>> queryBusReport() throws CustomerException {
        List<BusReportListVo> busReports = busReportService.queryBusReport();
        return Result.success(busReports);
    }

    /**
     * 按照日期查询每日报备数量
     *
     * @return
     */
    @RequestMapping("/selectDaysCount")
    public Result<List<DateAndDays>> selectDaysCount() {
        List<DateAndDays> busReports = busReportService.selectDaysCount();
        return Result.success(busReports);
    }

    /**
     * 债事链查询
     *
     * @param personIdCad
     * @return
     */
    @RequestMapping("/queryListChain")
    public Result<DebtChain> queryListChain(@NotBlank(message = "身份证号码不能为空") String personIdCad) {
        DebtChain list = busReportService.queryListChain(personIdCad);
        return Result.success(list);
    }

    /**
     * 更新审核状态
     *
     * @param status
     * @param reportId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateStatus")
    public Result updateStatus(@NotBlank(message = "状态不能为空") String status, @NotNull(message = "报备Id不能为空") Long reportId,@NotBlank(message = "审核原因不能为空") String checkReason) throws CustomerException {
        int i = busReportService.updateStatus(status, reportId,checkReason);
        return Result.success(i);
    }


    /**
     * 页面报备信息展示
     */
    @RequestMapping("/selectDebtInfos")
    public Result<PageInfo> selectDebtInfos(@NotNull(message = "页码不能为空") Integer pageNum,
                                            @NotNull(message = "当前显示条数不能为空") Integer pageSize,
                                            DebtInfoQuery debtInfoQuery) {
        if (!StringUtils.isBlank(debtInfoQuery.getBeginDate())) {
            debtInfoQuery.setBeginDate(debtInfoQuery.getBeginDate()+" 00:00:00");
        }
        if (!StringUtils.isBlank(debtInfoQuery.getEndDate())) {
            debtInfoQuery.setEndDate(debtInfoQuery.getEndDate()+" 23:59:00");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<DebtInfo> debtInfos = busReportService.selectDebtInfos(debtInfoQuery);
        PageInfo pageInfo = new PageInfo<>(debtInfos);
        return Result.success(pageInfo);
    }

}
