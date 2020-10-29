package com.smart.bracelet.controller.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.user.PubArea;
import com.smart.bracelet.model.vo.user.PubAreaVo;
import com.smart.bracelet.service.user.PubAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/pubAreaController/")
@Validated
public class PubAreaController {

    @Autowired
    private PubAreaService pubAreaService;

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid PubArea record) throws CustomerException {
        int insertSelective = pubAreaService.insertSelective(record);
        return Result.success(insertSelective);
    }

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "区域Id不能为空") Long areaId) throws CustomerException {
        int deleteByPrimaryKey = pubAreaService.deleteByPrimaryKey(areaId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid PubAreaVo record) throws CustomerException {
        int updateByPrimaryKeySelective = pubAreaService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<PubArea> selectByPrimaryKey(@NotNull(message = "区域Id不能为空") Long areaId) {
        PubArea pubArea = pubAreaService.selectByPrimaryKey(areaId);
        return Result.success(pubArea);
    }
    @RequestMapping("/selectByArName")
    public Result<List<PubArea>> selectByArName(String name){
        List<PubArea> pubAreas = pubAreaService.selectByArName(name);
        return Result.success(pubAreas);
    }
}
