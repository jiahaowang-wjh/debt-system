package com.smart.bracelet.controller.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusRelativePerson;
import com.smart.bracelet.model.vo.debt.BusRelativePersonBankVo;
import com.smart.bracelet.model.vo.debt.BusRelativePersonEnterpriseVo;
import com.smart.bracelet.model.vo.debt.BusRelativePersonPrivateVo;
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
     * 新增私人相对人信息
     * @param
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/insertPrivateSelective")
    public Result insertPrivateSelective(@Valid BusRelativePersonPrivateVo busRelativePersonPrivateVo) throws CustomerException{
        int insertPrivate = busRelativePersonService.insertPrivate(busRelativePersonPrivateVo);
        return Result.success(insertPrivate);
    }

    /**
     * 新增企业相对人信息
     * @param
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/insertEnterprise")
    public Result insertEnterprise(@Valid BusRelativePersonEnterpriseVo busRelativePersonEnterpriseVo) throws CustomerException{
        int insertPrivate = busRelativePersonService.insertEnterprise(busRelativePersonEnterpriseVo);
        return Result.success(insertPrivate);
    }

    /**
     * 新增银行相对人信息
     * @param
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/insertBank")
    public Result insertBank(@Valid BusRelativePersonBankVo busRelativePersonBankVo) throws CustomerException{
        int insertPrivate = busRelativePersonService.insertBank(busRelativePersonBankVo);
        return Result.success(insertPrivate);
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
