package com.smart.bracelet.controller.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.assets.BusBankGuarante;
import com.smart.bracelet.model.vo.assets.BusBankGuaranteVo;
import com.smart.bracelet.service.assets.BusBankGuaranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/busBankGuaranteController/")
@Validated
public class BusBankGuaranteController {

    @Autowired
    private BusBankGuaranteService busBankGuaranteService;

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "银行保函ID不能为空") Long bankGuaranteId) throws CustomerException {
        int deleteByPrimaryKey = busBankGuaranteService.deleteByPrimaryKey(bankGuaranteId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusBankGuarante record) throws CustomerException {
        Long insertSelective = busBankGuaranteService.insertSelective(record);
        return Result.success(insertSelective + "");
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<BusBankGuarante> selectByPrimaryKey(@NotNull(message = "银行保函ID不能为空") Long bankGuaranteId) {
        BusBankGuarante busBankGuarante = busBankGuaranteService.selectByPrimaryKey(bankGuaranteId);
        return Result.success(busBankGuarante);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusBankGuaranteVo record) throws CustomerException {
        int updateByPrimaryKeySelective = busBankGuaranteService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/queryList")
    public Result<List<BusBankGuarante>> queryList() {
        List<BusBankGuarante> busBankGuarantes = busBankGuaranteService.queryList();
        return Result.success(busBankGuarantes);
    }

}
