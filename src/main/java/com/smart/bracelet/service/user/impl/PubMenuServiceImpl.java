package com.smart.bracelet.service.user.impl;

import com.smart.bracelet.dao.user.PubMenuDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubMenu;
import com.smart.bracelet.model.po.user.PubMenuShow;
import com.smart.bracelet.model.vo.user.PubMenuVo;
import com.smart.bracelet.service.user.PubMenuService;
import com.smart.bracelet.utils.IdUtils;
import com.smart.bracelet.utils.TreeToolUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PubMenuServiceImpl implements PubMenuService {

    @Autowired
    private PubMenuDao pubMenuDao;

    /**
     * 通过Id删除菜单信息
     * @param menuId
     * @return
     * @throws CustomerException
     */
    @Override
    public int deleteByPrimaryKey(Long menuId) throws CustomerException {
        try {
            int deleteByPrimaryKey = pubMenuDao.deleteByPrimaryKey(menuId);
            log.info("菜单信息删除成功");
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("菜单信息删除失败,异常信息:{}",e.getMessage());
            throw new CustomerException("菜单信息删除失败");
        }
    }

    /**
     * 菜单信息新增
     * @param record
     * @return
     * @throws CustomerException
     */
    @Override
    public int insertSelective(PubMenu record) throws CustomerException {
        try {
            record.setMenuId(IdUtils.nextId());
            //是否有效,0无效,1有效.默认有效
            record.setIsenable("0");
            int insertSelective = pubMenuDao.insertSelective(record);
            log.info("菜单信息添加成功,受影响行数{}",insertSelective);
            return insertSelective;
        } catch (Exception e) {
            log.error("菜单信息添加失败,异常信息:{}",e.getMessage());
            throw new CustomerException("菜单信息添加失败");
        }
    }

    /**
     * 通过ID查询菜单信息
     * @param menuId
     * @return
     */
    @Override
    public PubMenu selectByPrimaryKey(Long menuId) {
        return pubMenuDao.selectByPrimaryKey(menuId);
    }

    /**
     * 修改菜单信息
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(PubMenuVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = pubMenuDao.updateByPrimaryKeySelective(record);
            log.info("菜单信息修改成功,受影响行数:{}",updateByPrimaryKeySelective);
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("菜单信息修改失败,异常信息:{}",e.getMessage());
            throw new CustomerException("菜单信息修改失败");
        }
    }

    /**
     * 查询所有菜单信息
     * @return
     */
    @Override
    public List<PubMenu> queryMenuList() {
        return pubMenuDao.queryMenuList();
    }

    @Override
    public List<PubMenuShow> selcetListAuth() {
        //存放根节点
        ArrayList<PubMenuShow> arrayList = new ArrayList<>();
        //存放子节点
        ArrayList<PubMenuShow> arrayList1 = new ArrayList<>();
        List<PubMenuShow> pubMenuShow = pubMenuDao.selcetListAuthOne();
        for (PubMenuShow item: pubMenuShow) {
            arrayList.add(item);
        }
        List<PubMenuShow> pubMenuShows = pubMenuDao.selcetListAuth();
        for (PubMenuShow item: pubMenuShows) {
            arrayList1.add(item);
        }
        TreeToolUtils treeToolUtils = new TreeToolUtils(arrayList,arrayList1);
        List<PubMenuShow> list = treeToolUtils.getTree();
        return list;
    }
}
