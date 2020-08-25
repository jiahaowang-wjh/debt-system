package com.smart.bracelet.controller.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.assets.BusAssessment;
import com.smart.bracelet.model.vo.assets.BusAssessmentVo;
import com.smart.bracelet.service.assets.BusAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping("/api/busAssessmentController")
public class BusAssessmentController {

    @Autowired
    private BusAssessmentService busAssessmentService;

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "不能为空资产评估ID") Long assessmentId) throws CustomerException {
        int deleteByPrimaryKey = busAssessmentService.deleteByPrimaryKey(assessmentId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusAssessment record) throws CustomerException {
        int i = busAssessmentService.insertSelective(record);
        return Result.success(i);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<BusAssessment> selectByPrimaryKey(@NotNull(message = "不能为空资产评估ID") Long assessmentId) {
        BusAssessment busAssessment = busAssessmentService.selectByPrimaryKey(assessmentId);
        return Result.success(busAssessment);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusAssessmentVo record) throws CustomerException {
        int i = busAssessmentService.updateByPrimaryKeySelective(record);
        return Result.success(i);
    }
}
