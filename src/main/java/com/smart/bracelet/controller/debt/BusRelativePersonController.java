package com.smart.bracelet.controller.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusRelativePerson;
import com.smart.bracelet.model.vo.debt.*;
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
     * 更新私人相对人信息
     * @param busRelativePersonPrivateUpdateVo
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updatePrivate")
    public Result updatePrivate(@Valid BusRelativePersonPrivateUpdateVo busRelativePersonPrivateUpdateVo) throws CustomerException{
        int updatePrivate = busRelativePersonService.updatePrivate(busRelativePersonPrivateUpdateVo);
        return Result.success(updatePrivate);
    }

    /**
     * 更新企业相对人信息
     * @param busRelativePersonEnterpriseUpdateVo
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateEnterprise")
    public Result updateEnterprise(@Valid BusRelativePersonEnterpriseUpdateVo busRelativePersonEnterpriseUpdateVo) throws CustomerException{
        int updateEnterprise = busRelativePersonService.updateEnterprise(busRelativePersonEnterpriseUpdateVo);
        return Result.success(updateEnterprise);
    }

    /**
     * 更新银行相对人信息
     * @param busRelativePersonBankUpdateVo
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateBank")
    public Result updateBank(@Valid BusRelativePersonBankUpdateVo busRelativePersonBankUpdateVo) throws CustomerException{
        int updateBank = busRelativePersonService.updateBank(busRelativePersonBankUpdateVo);
        return Result.success(updateBank);
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
