package com.smart.bracelet.controller.user;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.PubMenu;
import com.smart.bracelet.model.vo.PubMenuVo;
import com.smart.bracelet.service.PubMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 菜单管理
 */
@RestController
@RequestMapping("/api/pubMenu/")
@Validated
public class PubMenuController {

    @Autowired
    private PubMenuService pubMenuService;

    /**
     * 新增菜单信息
     * @param pubMenu
     * @return
     */
    @RequestMapping("/addMenu")
    public Result addMenu(@Valid PubMenu pubMenu) throws CustomerException {
        int insertSelective = pubMenuService.insertSelective(pubMenu);
        return Result.success(insertSelective);
    }

    /**
     * 通过Id删除菜单信息
     * @param menuId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/deleteMenuById")
    public Result deleteMenuById(@NotNull(message = "菜单Id不能为空") Long menuId) throws CustomerException {
        int deleteByPrimaryKey = pubMenuService.deleteByPrimaryKey(menuId);
        return Result.success(deleteByPrimaryKey);
    }

    /**
     * 通过Id查询菜单信息
     * @param menuId
     * @return
     */
    @RequestMapping("/selectByPrimaryKey")
    public Result<PubMenu> selectByPrimaryKey(@NotNull(message = "菜单Id不能为空") Long menuId){
        PubMenu pubMenu = pubMenuService.selectByPrimaryKey(menuId);
        return Result.success(pubMenu);
    }

    /**
     * 修改菜单信息
     * @param pubMenuVo
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(PubMenuVo pubMenuVo) throws CustomerException {
        int updateByPrimaryKeySelective = pubMenuService.updateByPrimaryKeySelective(pubMenuVo);
        return Result.success(updateByPrimaryKeySelective);
    }

    /**
     * 查询所有菜单信息
     * @return
     */
    @RequestMapping("/queryMenuList")
    public Result<List<PubMenu>> queryMenuList(){
        List<PubMenu> pubMenus = pubMenuService.queryMenuList();
        return Result.success(pubMenus);
    }
}
