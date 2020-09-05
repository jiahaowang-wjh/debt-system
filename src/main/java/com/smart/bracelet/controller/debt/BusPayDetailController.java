package com.smart.bracelet.controller.debt;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusPayDetail;
import com.smart.bracelet.model.vo.debt.BusPayDetailInfo;
import com.smart.bracelet.model.vo.debt.BusPayDetailVo;
import com.smart.bracelet.service.debt.BusPayDetailService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/busPayDetailController/")
@Validated
public class BusPayDetailController {

    @Autowired
    private BusPayDetailService busPayDetailService;

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusPayDetail record) throws CustomerException {
        Long insertSelective = busPayDetailService.insertSelective(record);
        return Result.success(insertSelective + "");
    }

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "支付ID不能为空") Long payId) throws CustomerException {
        int deleteByPrimaryKey = busPayDetailService.deleteByPrimaryKey(payId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusPayDetailVo record) throws CustomerException {
        int updateByPrimaryKeySelective = busPayDetailService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<BusPayDetail> selectByPrimaryKey(Long payId) {
        BusPayDetail busPayDetail = busPayDetailService.selectByPrimaryKey(payId);
        return Result.success(busPayDetail);
    }

    /**
     * 通过报备Id查询支付信息
     *
     * @param reportId
     * @return
     */
    @RequestMapping("/selectByReportId")
    public Result<List<BusPayDetail>> selectByReportId(@NotNull(message = "报备ID不能为空") Long reportId) {
        List<BusPayDetail> busPayDetails = busPayDetailService.selectByReportId(reportId);
        return Result.success(busPayDetails);
    }

    /**
     * 页面支付信息展示
     */
    @RequestMapping("/selectPayInfoList")
    public Result<PageInfo> selectPayInfoList(@NotNull(message = "页码不能为空") Integer pageNum,
                                              @NotNull(message = "当前显示条数不能为空") Integer pageSize,
                                              String debtNo) {
        PageHelper.startPage(pageNum, pageSize);
        List<BusPayDetailInfo> busPayDetailInfos = busPayDetailService.selectPayInfoList(debtNo);
        PageInfo<BusPayDetailInfo> busPayDetailInfoPageInfo = new PageInfo<>(busPayDetailInfos);
        return Result.success(busPayDetailInfoPageInfo);
    }

    /**
     * 更新状态
     *
     * @param status
     * @param payId
     * @return
     */
    @RequestMapping("/updateStatus")
    public Result updateStatus(@NotBlank(message = "状态不能为空") String status, @NotNull(message = "支付ID不能为空") Long payId) throws CustomerException {
        int updateStatus = busPayDetailService.updateStatus(status, payId);
        return Result.success(updateStatus);
    }

    /**
     * 通过报备Id和解债id查询支付信息
     *
     * @param reportId
     * @return
     */
    @RequestMapping("/selectByReportIdAndDebtId")
    public Result<List<BusPayDetail>> selectByReportIdAndDebtId(@NotNull(message = "报备Id不能为空") Long reportId, @NotNull(message = "解债Id不能为空") Long debtId) {
        List<BusPayDetail> busPayDetails = busPayDetailService.selectByReportIdAndDebtId(reportId, debtId);
        return Result.success(busPayDetails);
    }

    /**
     * 通过报备Id和资产Id查询支付信息
     *
     * @param reportId
     * @return
     */
    @RequestMapping("/selectByReportIdAndPropertId")
    public Result<List<BusPayDetail>> selectByReportIdAndPropertId(@NotNull(message = "报备Id不能为空") Long reportId, @NotNull(message = "资产Id不能为空")Long propertId) {
        List<BusPayDetail> busPayDetails = busPayDetailService.selectByReportIdAndPropertId(reportId, propertId);
        return Result.success(busPayDetails);
    }

}
