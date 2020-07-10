package com.smart.bracelet.controller.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusRelativePerson;
import com.smart.bracelet.model.vo.debt.BusRelativePersonVo;
import com.smart.bracelet.service.debt.BusRelativePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/busRelativePersonController/")
@Validated
public class BusRelativePersonController {

    @Autowired
    private BusRelativePersonService busRelativePersonService;

    /**
     * 新增相对人信息
     * @param record
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusRelativePerson record) throws CustomerException{
        int insertSelective = busRelativePersonService.insertSelective(record);
        return Result.success(insertSelective);
    }

    /**
     * 通过ID删除相对人信息
     * @param relativePerId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "相对人信息ID不能为空") Long relativePerId) throws CustomerException{
        int deleteByPrimaryKey = busRelativePersonService.deleteByPrimaryKey(relativePerId);
        return Result.success(deleteByPrimaryKey);
    }

    /**
     * 更新相对人信息
     * @param record
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusRelativePersonVo record) throws CustomerException{
        int updateByPrimaryKeySelective = busRelativePersonService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    /**
     * 通过Id查询相对人信息
     * @param relativePerId
     * @return
     */
    @RequestMapping("/selectByPrimaryKey")
    public Result<BusRelativePerson> selectByPrimaryKey(@NotNull(message = "相对人信息ID不能为空")Long relativePerId){
        BusRelativePerson busRelativePerson = busRelativePersonService.selectByPrimaryKey(relativePerId);
        return Result.success(busRelativePerson);
    }
}
