package com.smart.bracelet.controller.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusAssignmentAgreement;
import com.smart.bracelet.model.vo.debt.BusAssignmentAgreementVo;
import com.smart.bracelet.service.debt.BusAssignmentAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/BusAssignmentAgreementController/")
@Validated
public class BusAssignmentAgreementController {

    @Autowired
    private BusAssignmentAgreementService busAssignmentAgreementService;

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "转让协议ID不能为空") Long assignmentAgreementId) throws CustomerException {
        int deleteByPrimaryKey = busAssignmentAgreementService.deleteByPrimaryKey(assignmentAgreementId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusAssignmentAgreement record) throws CustomerException {
        int insertSelective = busAssignmentAgreementService.insertSelective(record);
        return Result.success(insertSelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(@NotNull(message = "转让协议ID不能为空")Long assignmentAgreementId) {
        BusAssignmentAgreement busAssignmentAgreement = busAssignmentAgreementService.selectByPrimaryKey(assignmentAgreementId);
        return Result.success(busAssignmentAgreement);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusAssignmentAgreementVo record) throws CustomerException {
        int updateByPrimaryKeySelective = busAssignmentAgreementService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/queryList")
    public Result<List<BusAssignmentAgreement>> queryList(){
        List<BusAssignmentAgreement> busAssignmentAgreements = busAssignmentAgreementService.queryList();
        return Result.success(busAssignmentAgreements);
    }
}
