package com.smart.bracelet.controller.debt;


import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusPayDetail;
import com.smart.bracelet.model.vo.debt.BusPayDetailVo;
import com.smart.bracelet.service.debt.BusPayDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/busPayDetailController/")
@Validated
public class BusPayDetailController {

    @Autowired
    private BusPayDetailService busPayDetailService;

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusPayDetail record) throws CustomerException{
        int insertSelective = busPayDetailService.insertSelective(record);
        return Result.success(insertSelective);
    }
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "支付ID不能为空") Long payId) throws CustomerException{
        int deleteByPrimaryKey = busPayDetailService.deleteByPrimaryKey(payId);
        return Result.success(deleteByPrimaryKey);
    }
    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusPayDetailVo record) throws CustomerException{
        int updateByPrimaryKeySelective = busPayDetailService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }
        @RequestMapping("/selectByPrimaryKey")
    public Result<BusPayDetail> selectByPrimaryKey(Long payId){
        BusPayDetail busPayDetail = busPayDetailService.selectByPrimaryKey(payId);
        return Result.success(busPayDetail);
    }
}
