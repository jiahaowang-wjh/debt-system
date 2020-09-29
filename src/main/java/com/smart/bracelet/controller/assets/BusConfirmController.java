package com.smart.bracelet.controller.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.assets.BusConfirm;
import com.smart.bracelet.model.vo.assets.BusConfirmShow;
import com.smart.bracelet.model.vo.assets.BusConfirmVo;
import com.smart.bracelet.service.assets.BusConfirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/busConfirmController/")
@Validated
public class BusConfirmController {

    @Autowired
    private BusConfirmService busConfirmService;

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "确认ID不能为空") Long confirmtId) throws CustomerException {
        int deleteByPrimaryKey = busConfirmService.deleteByPrimaryKey(confirmtId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusConfirm record) throws CustomerException {
        int insertSelective = busConfirmService.insertSelective(record);
        return Result.success(insertSelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<BusConfirm> selectByPrimaryKey(@NotNull(message = "确认ID不能为空") Long confirmtId) {
        BusConfirm busConfirm = busConfirmService.selectByPrimaryKey(confirmtId);
        return Result.success(busConfirm);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusConfirmVo record) throws CustomerException {
        int updateByPrimaryKeySelective = busConfirmService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/queryList")
    public Result<List<BusConfirm>> queryList() {
        List<BusConfirm> busConfirms = busConfirmService.queryList();
        return Result.success(busConfirms);
    }

    /**
     * 资产债权确认页面初始化
     *
     * @param propertId
     * @return
     */
    @RequestMapping("/initialize")
    public Result<BusConfirmShow> initialize(@NotNull(message = "资产ID不能为空") Long propertId) throws ParseException {
        BusConfirmShow initialize = busConfirmService.initialize(propertId);
        return Result.success(initialize);
    }


    /**
     * 通过资产ID查询资产债权确认
     *
     * @param propertId
     * @return
     */
    @RequestMapping("/selectByPropertId")
    public Result<BusConfirm> selectByPropertId(@NotNull(message = "资产ID不能为空") Long propertId) {
        BusConfirm busConfirm = busConfirmService.selectByPropertId(propertId);
        return Result.success(busConfirm);
    }
}
