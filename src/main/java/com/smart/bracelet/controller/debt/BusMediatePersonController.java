package com.smart.bracelet.controller.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusMediatePerson;
import com.smart.bracelet.model.vo.debt.BusMediatePersonVo;
import com.smart.bracelet.service.debt.BusMediatePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/busMediatePersonController/")
@Validated
public class BusMediatePersonController {

    @Autowired
    private BusMediatePersonService busMediatePersonService;

    @RequestMapping("/deleteByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('debt:delete')")
    public Result deleteByPrimaryKey(@NotNull(message = "担保人ID不能为空") Long mediatePersonId) throws CustomerException {
        int deleteByPrimaryKey = busMediatePersonService.deleteByPrimaryKey(mediatePersonId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/insertSelective")
    @PreAuthorize("hasAnyAuthority('debt:add')")
    public Result insertSelective(@Valid BusMediatePerson record) throws CustomerException {
        int insertSelective = busMediatePersonService.insertSelective(record);
        return Result.success(insertSelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('debt:select')")
    public Result<BusMediatePerson> selectByPrimaryKey(@NotNull(message = "担保人ID不能为空") Long mediatePersonId) {
        BusMediatePerson busMediatePerson = busMediatePersonService.selectByPrimaryKey(mediatePersonId);
        return Result.success(busMediatePerson);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    @PreAuthorize("hasAnyAuthority('debt:update')")
    public Result updateByPrimaryKeySelective(@Valid BusMediatePersonVo record) throws CustomerException {
        int updateByPrimaryKeySelective = busMediatePersonService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/queryList")
    @PreAuthorize("hasAnyAuthority('debt:select')")
    public Result<List<BusMediatePerson>> queryList() {
        List<BusMediatePerson> busMediatePeople = busMediatePersonService.queryList();
        return Result.success(busMediatePeople);
    }
}
