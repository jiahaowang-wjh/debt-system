package com.smart.bracelet.service.user.impl;

import com.smart.bracelet.dao.debt.PubRolemenuDao;
import com.smart.bracelet.dao.user.PubRoleDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubMenu;
import com.smart.bracelet.model.po.user.PubRole;
import com.smart.bracelet.model.po.user.PubRoleauth;
import com.smart.bracelet.model.po.user.PubRolemenu;
import com.smart.bracelet.model.vo.user.PubRoleVo;
import com.smart.bracelet.service.debt.PubRolemenuService;
import com.smart.bracelet.service.user.PubRoleService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class PubRoleServiceImpl implements PubRoleService {

    @Autowired
    private PubRoleDao pubRoleDao;

    @Autowired
    private PubRolemenuService pubRolemenuService;

    /**
     * 通过Id删除角色信息
     *
     * @param roleId
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Long roleId) throws CustomerException {
        try {
            int deleteByPrimaryKey = pubRoleDao.deleteByPrimaryKey(roleId);
            if (deleteByPrimaryKey != 0) {
                //删除角色权限表
                pubRoleDao.deleteRoleauthByPrimaryKey(roleId);
                //删除角色菜单表
                pubRoleDao.deleteRoleMenuByPrimaryKey(roleId);
            }
            log.info("删除角色信息成功");
            return deleteByPrimaryKey;
        } catch (Exception e) {
            log.error("删除角色信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("删除角色信息失败");
        }
    }


    /**
     * 新增角色信息
     *
     * @param record
     * @return
     */
    @Override
    public int insertSelective(PubRole record) throws CustomerException {
        try {
            record.setRoleId(IdUtils.nextId());
            record.setIsenable("1");
            int insertSelective = pubRoleDao.insertSelective(record);
            log.info("新增角色信息成功");
            return insertSelective;
        } catch (Exception e) {
            log.error("新增角色信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("新增角色信息失败");
        }
    }

    /**
     * 通过Id查询角色信息
     *
     * @param roleId
     * @return
     */
    @Override
    public PubRole selectByPrimaryKey(Long roleId) {
        return pubRoleDao.selectByPrimaryKey(roleId);
    }

    /**
     * 修改角色信息
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(PubRoleVo record) throws CustomerException {
        try {
            int updateByPrimaryKeySelective = pubRoleDao.updateByPrimaryKeySelective(record);
            log.info("修改角色信息成功");
            return updateByPrimaryKeySelective;
        } catch (Exception e) {
            log.error("修改角色信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("修改角色信息失败");
        }
    }

    /**
     * 给角色分配权限
     *
     * @param pubRoleauth
     * @return
     * @throws CustomerException
     */
    @Override
    public int addRoleAuth(PubRoleauth pubRoleauth) throws CustomerException {
        try {
            pubRoleauth.setRoleauthId(IdUtils.nextId());
            int addRoleAuth = pubRoleDao.addRoleAuth(pubRoleauth);
            log.info("角色权限分配成功,受影响行数:{}", addRoleAuth);
            return addRoleAuth;
        } catch (Exception e) {
            log.error("角色权限分配失败,异常信息:{}", e.getMessage());
            throw new CustomerException("角色权限分配失败");
        }
    }

    /**
     * 批量分配菜单
     *
     * @param
     * @return
     * @throws CustomerException
     */
    @Override
    public int addRoleMenu(Long[] menus, Long roleId) throws CustomerException {
        if(menus==null||menus.length==0){
            throw new CustomerException("菜单Id不能为空");
        }
        try {
            List<PubRolemenu> list = new ArrayList<>();
            for (Long item : menus) {
                PubRolemenu pubRolemenu = new PubRolemenu();
                pubRolemenu.setRolemenuId(IdUtils.nextId());
                pubRolemenu.setMenuId(item);
                pubRolemenu.setRoleId(roleId);
                list.add(pubRolemenu);
            }
            int addRoleMenu = pubRoleDao.addRoleMenu(list);
            log.info("菜单添加成功,受影响行数:{}", addRoleMenu);
            return addRoleMenu;
        } catch (Exception e) {
            log.error("菜单添加失败,异常信息:{}", e.getMessage());
            throw new CustomerException("菜单添加失败");
        }
    }

    @Override
    public int delRoleList(Long[] roleIds) throws CustomerException {
        try {
            int delRoleList = pubRoleDao.delRoleList(roleIds);
            log.info("批量删除角色成功,受影响行数:{}", delRoleList);
            return delRoleList;
        } catch (Exception e) {
            log.error("批量删除角色失败,异常信息:{}", e.getMessage());
            throw new CustomerException("批量删除角色失败");
        }
    }

    /**
     * (批量分配权限)
     *
     * @param
     * @param authId  权限ID
     * @return
     * @throws CustomerException
     */
    @Override
    public int addRoleAuthList(String authId, Long roleId, String menuId, String note) throws CustomerException {
        List<PubRoleauth> pubRoleauths = new ArrayList<>();
        try {
            List<String> authIdList = Arrays.asList(authId.split(","));
            //获取单个权限ID并添加
            for (String item : authIdList) {
                PubRoleauth pubRoleauth = new PubRoleauth();
                pubRoleauth.setRoleauthId(IdUtils.nextId());
                pubRoleauth.setAuthId(Long.parseLong(item));
                pubRoleauth.setRoleId(roleId);
                pubRoleauth.setNote(note);
                pubRoleauths.add(pubRoleauth);
            }
            // pubRolemenuService.addListRolemenu(menuId,roleId);
            int addRoleMenu = pubRoleDao.addRoleAuthList(pubRoleauths);
            log.info("批量角色权限分配成功,受影响行数:{}", addRoleMenu);
            return addRoleMenu;
        } catch (Exception e) {
            log.error("批量角色权限分配失败,异常信息:{}", e.getMessage());
            throw new CustomerException("批量角色权限分配失败");
        }
    }

    @Override
    public List<PubRole> queryRole() {
        return pubRoleDao.queryRole();
    }
}
