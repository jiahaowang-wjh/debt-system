package com.smart.bracelet.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.user.PubDiction;
import com.smart.bracelet.model.vo.user.PubDictionVo;
import com.smart.bracelet.service.user.PubDictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 字典管理
 */
@RestController
@RequestMapping("/api/pubDictionController/")
@Validated
public class PubDictionController {

    @Autowired
    private PubDictionService pubDictionService;

    /**
     * 新增字典信息
     *
     * @param pubDiction
     * @return
     */
    @RequestMapping("/insertSelective")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public Result insertSelective(@Valid PubDiction pubDiction) throws CustomerException {
        int insertSelective = pubDictionService.insertSelective(pubDiction);
        return Result.success(insertSelective);
    }

    /**
     * 通过ID删除字典信息
     *
     * @param dictionId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/deleteByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('user:delete')")
    public Result deleteByPrimaryKey(@NotNull(message = "字典ID不能为空") Long dictionId) throws CustomerException {
        int deleteByPrimaryKey = pubDictionService.deleteByPrimaryKey(dictionId);
        return Result.success(deleteByPrimaryKey);
    }

    /**
     * 更新字典
     *
     * @param record
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateByPrimaryKeySelective")
    @PreAuthorize("hasAnyAuthority('user:select')")
    public Result updateByPrimaryKeySelective(@Valid PubDictionVo record) throws CustomerException {
        int updateByPrimaryKeySelective = pubDictionService.updateByPrimaryKeySelective(record);
        return Result.success(updateByPrimaryKeySelective);
    }

    /**
     * 通过Id查询字典信息
     *
     * @param dictionId
     * @return
     */
    @RequestMapping("/selectByPrimaryKey")
    @PreAuthorize("hasAnyAuthority('user:select')")
    public Result<PubDiction> selectByPrimaryKey(@NotNull(message = "字典信息Id不能为空") Long dictionId) {
        PubDiction pubDiction = pubDictionService.selectByPrimaryKey(dictionId);
        return Result.success(pubDiction);
    }

    /**
     * 查询所有字典分页
     *
     * @return
     */
    @RequestMapping("/queryDicList")
    @PreAuthorize("hasAnyAuthority('user:select')")
    public Result<PageInfo> queryDicList(@NotNull(message = "页码不能为空") Integer pageNum, @NotNull(message = "当前显示条数不能为空") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PubDiction> pubDictions = pubDictionService.queryDicList();
        PageInfo<PubDiction> pubDictionPageInfo = new PageInfo<>(pubDictions);
        return Result.success(pubDictionPageInfo);
    }

    /**
     * 批量删除字典信息
     *
     * @param dictionIds
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/delDictionList")
    @PreAuthorize("hasAnyAuthority('user:delete')")
    public Result delDictionList(@NotNull(message = "字典信息Id不能为空") Long[] dictionIds) throws CustomerException {
        int delDictionList = pubDictionService.delDictionList(dictionIds);
        return Result.success(delDictionList);
    }

    /**
     * 通过类型查询字典
     *
     * @param dictionType
     * @return
     */
    @RequestMapping("/selectByType")
    @PreAuthorize("hasAnyAuthority('user:select')")
    public Result<List<PubDiction>> selectByType(@NotBlank(message = "字典类型不能为空") String dictionType) {
        List<PubDiction> pubDictions = pubDictionService.selectByType(dictionType);
        return Result.success(pubDictions);
    }

    /**
     * 查询代理销售合同商品
     */
    @RequestMapping("/selectCommodity")
    @PreAuthorize("hasAnyAuthority('user:select')")
    public Result<List<PubDiction>> selectCommodity() {
        List<PubDiction> pubDictions = pubDictionService.selectCommodity();
        return Result.success(pubDictions);
    }


    /**
     * 查询代理销售合同产地
     */
    @RequestMapping("/selectPlace")
    @PreAuthorize("hasAnyAuthority('user:select')")
    public Result<List<PubDiction>> selectPlace() {
        List<PubDiction> pubDictions = pubDictionService.selectPlace();
        return Result.success(pubDictions);
    }

    /**
     * 查询代理销售合同规格
     */
    @RequestMapping("/selectNorm")
    @PreAuthorize("hasAnyAuthority('user:select')")
    public Result<List<PubDiction>> selectNorm() {
        List<PubDiction> pubDictions = pubDictionService.selectNorm();
        return Result.success(pubDictions);
    }

    /**
     * 查询代理销售合同计量单位
     */
    @RequestMapping("/selectMeasure")
    @PreAuthorize("hasAnyAuthority('user:select')")
    public Result<List<PubDiction>> selectMeasure() {
        List<PubDiction> pubDictions = pubDictionService.selectMeasure();
        return Result.success(pubDictions);
    }

    /**
     * 查询代理销售合同计量包装
     */
    @RequestMapping("/selectPackage")
    @PreAuthorize("hasAnyAuthority('user:select')")
    public Result<List<PubDiction>> selectPackage() {
        List<PubDiction> pubDictions = pubDictionService.selectPackage();
        return Result.success(pubDictions);
    }
}
