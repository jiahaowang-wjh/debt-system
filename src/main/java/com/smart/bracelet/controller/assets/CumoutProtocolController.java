package com.smart.bracelet.controller.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.assets.CumoutProtocol;
import com.smart.bracelet.model.vo.assets.CommissionOnLine;
import com.smart.bracelet.service.assets.CumoutProtocolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.text.ParseException;

@RestController
@RequestMapping("/api/cumoutProtocolController/")
@Validated
public class CumoutProtocolController {


    @Autowired
    private CumoutProtocolService cumoutProtocolService;


    /**
     * 新增线上委托销售合同
     * @param record
     * @return
     */
    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid CumoutProtocol record) throws CustomerException {
        Long aLong = cumoutProtocolService.insertSelective(record);
        return Result.success(aLong);
    }

    /**
     * 初始化线上委托销售合同
     * @param propertId
     * @return
     */
    @RequestMapping("/initialize")
    public Result<CommissionOnLine> initialize(@NotNull(message = "资产ID不能为空") Long propertId, @NotNull(message = "公司ID") Long comId) throws ParseException, CustomerException{
        CommissionOnLine initialize = cumoutProtocolService.initialize(propertId,comId);
        return Result.success(initialize);
    }


}
