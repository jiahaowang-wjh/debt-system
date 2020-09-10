package com.smart.bracelet.controller.assets;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.assets.BusCollectionLetter;
import com.smart.bracelet.model.vo.assets.BusCollectionLetterShow;
import com.smart.bracelet.model.vo.assets.BusCollectionLetterVo;
import com.smart.bracelet.service.assets.BusCollectionLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/busCollectionLetterController/")
@Validated
public class BusCollectionLetterController {

    @Autowired
    private BusCollectionLetterService busCollectionLetterService;

    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "资催款函ID不能为空") Long collectionLettertId) throws CustomerException {
        int deleteByPrimaryKey = busCollectionLetterService.deleteByPrimaryKey(collectionLettertId);
        return Result.success(deleteByPrimaryKey);
    }

    @RequestMapping("/insertSelective")
    public Result insertSelective(@Valid BusCollectionLetter record) throws CustomerException {
        int insertSelective = busCollectionLetterService.insertSelective(record);
        return Result.success(insertSelective);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Result<BusCollectionLetter> selectByPrimaryKey(@NotNull(message = "资催款函ID不能为空") Long collectionLettertId) {
        BusCollectionLetter busCollectionLetter = busCollectionLetterService.selectByPrimaryKey(collectionLettertId);
        return Result.success(busCollectionLetter);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@Valid BusCollectionLetterVo record) throws CustomerException {
        int updateByPrimaryKeySelective = busCollectionLetterService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    @RequestMapping("/queryList")
    public Result<List<BusCollectionLetter>> queryList() {
        List<BusCollectionLetter> busCollectionLetters = busCollectionLetterService.queryList();
        return Result.success(busCollectionLetters);
    }

    /**
     * 资产债权确认页面初始化
     * @param relativePerId
     * @return
     */
    @RequestMapping("/initialize")
    public Result<BusCollectionLetterShow> initialize(@NotNull(message = "相对人ID不能为空") Long relativePerId){
        BusCollectionLetterShow initialize = busCollectionLetterService.initialize(relativePerId);
        return Result.success(initialize);
    }

    /**
     * 通过资产Id查询催款函
     * @param propertId
     * @return
     */
    @RequestMapping("/selectByPropertId")
    public Result<BusCollectionLetter> selectByPropertId(@NotNull(message = "资产ID不能为空") Long propertId){
        BusCollectionLetter busCollectionLetter = busCollectionLetterService.selectByPropertId(propertId);
        return Result.success(busCollectionLetter);
    }

}
