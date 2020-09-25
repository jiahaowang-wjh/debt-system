package com.smart.bracelet.controller.doc;

import com.baomidou.mybatisplus.extension.api.R;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.service.doc.BusWordConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO:
 *
 * @author liuzq
 * @version 1.0
 * @date 2020/9/20
 **/
@RestController
//@RequestMapping("/api/wordConversion")
@RequestMapping("/wordConversion")
public class BusWordConversionController {

    @Autowired
    private BusWordConversionService busWordConversionService;

    /**
     * 填充word并保存为指定格式
     * */
    @RequestMapping("/fillInWordAndSaveAsSpecifyFormat")
//    @PreAuthorize("hasAnyAuthority('')")
    public Result fillInWordAndSaveAsSpecifyFormat() {
        busWordConversionService.fillInWordAndSaveAsSpecifyFormat();
        return Result.success();
    }

}
