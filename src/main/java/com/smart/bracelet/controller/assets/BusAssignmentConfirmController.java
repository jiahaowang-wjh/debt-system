package com.smart.bracelet.controller.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.assets.BusAssignmentConfirm;
import com.smart.bracelet.model.vo.assets.BusAssignmentConfirmShow;
import com.smart.bracelet.model.vo.assets.BusAssignmentConfirmVo;
import com.smart.bracelet.service.assets.BusAssignmentConfirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/BusAssignmentConfirmController/")
@Validated
public class BusAssignmentConfirmController {

    @Autowired
    private BusAssignmentConfirmService busAssignmentConfirmService;

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "确认ID不能为空") Long posseConfirmtId) throws CustomerException {
        int deleteByPrimaryKey = busAssignmentConfirmService.deleteByPrimaryKey(posseConfirmtId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusAssignmentConfirm record) throws CustomerException {
        int insertSelective = busAssignmentConfirmService.insertSelective(record);
        return Result.success(insertSelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<BusAssignmentConfirm> selectByPrimaryKey(@NotNull(message = "确认ID不能为空") Long posseConfirmtId) {
        BusAssignmentConfirm busAssignmentConfirm = busAssignmentConfirmService.selectByPrimaryKey(posseConfirmtId);
        return Result.success(busAssignmentConfirm);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusAssignmentConfirmVo record) throws CustomerException {
        int updateByPrimaryKeySelective = busAssignmentConfirmService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/queryList")
    public Result<List<BusAssignmentConfirm>> queryList() {
        List<BusAssignmentConfirm> busAssignmentConfirms = busAssignmentConfirmService.queryList();
        return Result.success(busAssignmentConfirms);
    }
    /**
     * 初始化资产债权转让确认页面
     * @return
     */
    @RequestMapping("/initialize")
    public Result<BusAssignmentConfirmShow> initialize(@NotNull(message = "报备ID不能为空") Long reportId){
        BusAssignmentConfirmShow initialize = busAssignmentConfirmService.initialize(reportId);
        return Result.success(initialize);
    }

}
