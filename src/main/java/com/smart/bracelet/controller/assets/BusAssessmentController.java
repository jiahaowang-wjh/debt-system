package com.smart.bracelet.controller.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.assets.BusAssessment;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.assets.BusAssessmentInit;
import com.smart.bracelet.model.vo.assets.BusAssessmentVo;
import com.smart.bracelet.service.assets.BusAssessmentService;
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
@Validated
@RequestMapping("/api/busAssessmentController")
public class BusAssessmentController {

    @Autowired
    private BusAssessmentService busAssessmentService;

    @RequestMapping("/deleteByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('assets:delete')")
    public Result deleteByPrimaryKey(@NotNull(message = "不能为空资产评估ID") Long assessmentId) throws CustomerException {
        int deleteByPrimaryKey = busAssessmentService.deleteByPrimaryKey(assessmentId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/insertSelective")
    @PreAuthorize("hasAnyAuthority('assets:add')")
    public Result insertSelective(@Valid BusAssessment record) throws CustomerException {
        Long i = busAssessmentService.insertSelective(record);
        return Result.success(i + "");
    }

    @RequestMapping("/selectByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('assets:select')")
    public Result<BusAssessment> selectByPrimaryKey(@NotNull(message = "不能为空资产评估ID") Long assessmentId) {
        BusAssessment busAssessment = busAssessmentService.selectByPrimaryKey(assessmentId);
        return Result.success(busAssessment);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    @PreAuthorize("hasAnyAuthority('assets:update')")
    public Result updateByPrimaryKeySelective(@Valid BusAssessmentVo record) throws CustomerException {
        int i = busAssessmentService.updateByPrimaryKeySelective(record);
        return Result.success(i);
    }

    /**
     * 按照日期展示每日数据
     *
     * @return
     */
    @RequestMapping("/selectDaysCount")
    @PreAuthorize("hasAnyAuthority('assets:select')")
    public Result<List<DateAndDays>> selectDaysCount(@NotBlank(message = "公司类型不能为空") String type) {
        List<DateAndDays> dateAndDays = busAssessmentService.selectDaysCount(type);
        return Result.success(dateAndDays);
    }

    /**
     * 资产评估页面初始化
     */
    @RequestMapping("/initialize")
    @PreAuthorize("hasAnyAuthority('assets:select')")
    public Result<BusAssessmentInit> initialize(@NotNull(message = "相对人ID不能为空") Long relativePerId) {
        BusAssessmentInit initialize = busAssessmentService.initialize(relativePerId);
        return Result.success(initialize);
    }

    /**
     * 通过资产id获取资产评估信息
     */
    @RequestMapping("/selectByPropertId")
    @PreAuthorize("hasAnyAuthority('assets:select')")
    public Result<BusAssessment> selectByPropertId(@NotNull(message = "资产ID不能为空") Long propertId) {
        BusAssessment busAssessment = busAssessmentService.selectByPropertId(propertId);
        return Result.success(busAssessment);
    }

}
