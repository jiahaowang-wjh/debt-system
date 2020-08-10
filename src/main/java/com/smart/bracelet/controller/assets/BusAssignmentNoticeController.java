package com.smart.bracelet.controller.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.assets.BusAssignmentNotice;
import com.smart.bracelet.model.vo.assets.BusAssignmentNoticeVo;
import com.smart.bracelet.service.assets.BusAssignmentNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
    @RequestMapping("/api/busAssignmentNoticeController/")
@Validated
public class BusAssignmentNoticeController {

    @Autowired
    private BusAssignmentNoticeService busAssignmentNoticeService;

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "转让通知ID不能为空") Long assignmentNoticeId) throws CustomerException {
        int deleteByPrimaryKey = busAssignmentNoticeService.deleteByPrimaryKey(assignmentNoticeId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusAssignmentNotice record) throws CustomerException {
        int insertSelective = busAssignmentNoticeService.insertSelective(record);
        return Result.success(insertSelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<BusAssignmentNotice> selectByPrimaryKey(@NotNull(message = "转让通知ID不能为空") Long assignmentNoticeId) {
        BusAssignmentNotice busAssignmentNotice = busAssignmentNoticeService.selectByPrimaryKey(assignmentNoticeId);
        return Result.success(busAssignmentNotice);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusAssignmentNoticeVo record) throws CustomerException {
        int updateByPrimaryKeySelective = busAssignmentNoticeService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/queryList")
    public Result<List<BusAssignmentNotice>> queryList() {
        List<BusAssignmentNotice> busAssignmentNotices = busAssignmentNoticeService.queryList();
        return Result.success(busAssignmentNotices);
    }
}