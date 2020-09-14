package com.smart.bracelet.controller.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.assets.BusAssignmentNotice;
import com.smart.bracelet.model.vo.assets.BusAssignmentNoticeShow;
import com.smart.bracelet.model.vo.assets.BusAssignmentNoticeVo;
import com.smart.bracelet.service.assets.BusAssignmentNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('assets:delete')")
    public Result deleteByPrimaryKey(@NotNull(message = "转让通知ID不能为空") Long assignmentNoticeId) throws CustomerException {
        int deleteByPrimaryKey = busAssignmentNoticeService.deleteByPrimaryKey(assignmentNoticeId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/insertSelective")
    @PreAuthorize("hasAnyAuthority('assets:add')")
    public Result insertSelective(@Valid BusAssignmentNotice record) throws CustomerException {
        Long insertSelective = busAssignmentNoticeService.insertSelective(record);
        return Result.success(insertSelective + "");
    }

    @RequestMapping("/selectByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('assets:select')")
    public Result<BusAssignmentNotice> selectByPrimaryKey(@NotNull(message = "转让通知ID不能为空") Long assignmentNoticeId) {
        BusAssignmentNotice busAssignmentNotice = busAssignmentNoticeService.selectByPrimaryKey(assignmentNoticeId);
        return Result.success(busAssignmentNotice);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    @PreAuthorize("hasAnyAuthority('assets:update')")
    public Result updateByPrimaryKeySelective(@Valid BusAssignmentNoticeVo record) throws CustomerException {
        int updateByPrimaryKeySelective = busAssignmentNoticeService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/queryList")
    @PreAuthorize("hasAnyAuthority('assets:select')")
    public Result<List<BusAssignmentNotice>> queryList() {
        List<BusAssignmentNotice> busAssignmentNotices = busAssignmentNoticeService.queryList();
        return Result.success(busAssignmentNotices);
    }


    /**
     * 初始化资产债权转让通知书
     *
     * @param relativePerId
     * @return
     */
    @RequestMapping("/initialize")
    @PreAuthorize("hasAnyAuthority('assets:select')")
    public Result<BusAssignmentNoticeShow> initialize(@NotNull(message = "相对人Id不能为空") Long relativePerId) {
        BusAssignmentNoticeShow initialize = busAssignmentNoticeService.initialize(relativePerId);
        return Result.success(initialize);
    }

    /**
     * 通过资产id查询资产债权转让通知书
     *
     * @param propertId
     * @return
     */
    @RequestMapping("/selectByPropertId")
    @PreAuthorize("hasAnyAuthority('assets:select')")
    public Result<BusAssignmentNotice> selectByPropertId(@NotNull(message = "资产Id不能为空") Long propertId) {
        BusAssignmentNotice busAssignmentNotice = busAssignmentNoticeService.selectByPropertId(propertId);
        return Result.success(busAssignmentNotice);
    }
}
