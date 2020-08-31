package com.smart.bracelet.controller.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.assets.Manner1;
import com.smart.bracelet.model.po.assets.Manner1AndManner2;
import com.smart.bracelet.model.po.assets.Manner2;
import com.smart.bracelet.model.vo.assets.BusCompromiseAgreementShow;
import com.smart.bracelet.model.vo.assets.Manner1Vo;
import com.smart.bracelet.model.vo.assets.Manner2Vo;
import com.smart.bracelet.service.assets.BusCompromiseAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/busCompromiseAgreementController/")
@Validated
public class BusCompromiseAgreementController {

    @Autowired
    private BusCompromiseAgreementService busCompromiseAgreementService;

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "和解协议ID不能为空") Long compromiseAgreementId) throws CustomerException {
        int deleteByPrimaryKey = busCompromiseAgreementService.deleteByPrimaryKey(compromiseAgreementId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/insertSelectiveManner1")
    public Result insertSelectiveManner1(@Valid Manner1 manner1Vo) throws CustomerException {
        int i = busCompromiseAgreementService.insertSelectiveManner1(manner1Vo);
        return Result.success(i);
    }

    @RequestMapping("/insertSelectiveManner2")
    public Result insertSelectiveManner2(@Valid Manner2 manner2Vo) throws CustomerException {
        int i = busCompromiseAgreementService.insertSelectiveManner2(manner2Vo);
        return Result.success(i);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<Manner1AndManner2> selectByPrimaryKey(@NotNull(message = "和解协议ID不能为空") Long compromiseAgreementId) throws CustomerException {
        Manner1AndManner2 manner1AndManner2 = busCompromiseAgreementService.selectByPrimaryKey(compromiseAgreementId);
        return Result.success(manner1AndManner2);
    }


    @RequestMapping("/updateByPrimaryKeySelectiveManner1Vo")
    public Result updateByPrimaryKeySelectiveManner1Vo(@Valid Manner1Vo record) throws CustomerException {
        int i = busCompromiseAgreementService.updateByPrimaryKeySelectiveManner1Vo(record);
        return Result.success(i);
    }

    @RequestMapping("/updateByPrimaryKeySelectiveManner2Vo")
    public Result updateByPrimaryKeySelectiveManner2Vo(@Valid Manner2Vo record) throws CustomerException {
        int i = busCompromiseAgreementService.updateByPrimaryKeySelectiveManner2Vo(record);
        return Result.success(i);
    }

    @RequestMapping("/queryList")
    public Result<List<Manner1AndManner2>> queryList() throws CustomerException {
        List<Manner1AndManner2> manner1AndManner2s = busCompromiseAgreementService.queryList();
        return Result.success(manner1AndManner2s);
    }
    /**
     * 初始化和解协议页面
     * @param relativePerId
     * @return
     */
    @RequestMapping("/initialize")
    public Result<BusCompromiseAgreementShow> initialize(@NotNull(message = "相对人ID不能为空") Long relativePerId) throws ParseException {
        BusCompromiseAgreementShow initialize = busCompromiseAgreementService.initialize(relativePerId);
        return Result.success(initialize);
    }
}
