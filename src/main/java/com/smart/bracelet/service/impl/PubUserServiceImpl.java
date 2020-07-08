package com.smart.bracelet.service.impl;

import com.smart.bracelet.dao.PubUserDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.PubMenu;
import com.smart.bracelet.model.po.PubUser;
import com.smart.bracelet.model.vo.PubUserVo;
import com.smart.bracelet.service.PubUserService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PubUserServiceImpl implements PubUserService {


    @Autowired
    private PubUserDao pubUserDao;

    /**
     * 通过ID删除用户信息
     * @param userId
     * @return
     * @throws CustomerException
     */
    @Override
    public int deleteByPrimaryKey(Long userId) throws CustomerException {
        try {
            int i = pubUserDao.deleteByPrimaryKey(userId);
            log.info("删除用户信息成功,首映影响行数:{}",i);
            return i;
        } catch (Exception e) {
            log.error("删除用户信息失败,异常信息",e.getMessage());
            throw new CustomerException("删除用户信息失败");
        }
    }

    /**
     * 新增用户信息
     * @param record
     * @return
     * @throws CustomerException
     */
    @Override
    public int insertSelective(PubUser record) throws CustomerException {
        try {
            record.setUserId(IdUtils.nextId());
            record.setPasswordMd5(new BCryptPasswordEncoder().encode(record.getPasswordMd5()));
            //是否有效,0无效,1有效,默认有效
            record.setIsenable("1");
            int i = pubUserDao.insertSelective(record);
            log.info("用户信息添加成功,受影响行数:{}",i);
            return i;
        } catch (Exception e) {
            log.error("用户信息添加失败,异常信息:{}",e.getMessage());
            throw new CustomerException("用户信息添加失败");
        }
    }

    /**
     * 通过Id查询用户信息
     * @param userId
     * @return
     */
    @Override
    public PubUser selectByPrimaryKey(Long userId) {
        return pubUserDao.selectByPrimaryKey(userId);
    }

    /**
     * 修改用户信息
     * @param record
     * @return
     * @throws CustomerException
     */
    @Override
    public int updateByPrimaryKeySelective(PubUserVo record) throws CustomerException {
        try {
            int i = pubUserDao.updateByPrimaryKeySelective(record);
            log.info("修改用户信息成功,受影响行数:{}",i);
            return i;
        } catch (Exception e) {
            log.error("修改用户信息失败,异常信息:{}",e.getMessage());
            throw new CustomerException("修改用户信息失败");
        }
    }

    @Override
    public PubUser selectUserInfoAccount(String pubUser) {
        return pubUserDao.selectUserInfoAccount(pubUser);
    }

    /**
     * 查询用户权限
     * @param logName
     * @return
     */
    @Override
    public List<String> selectUserAuth(String logName) {
        return pubUserDao.selectUserAuth(logName);
    }

    @Override
    public List<PubUser> queryUserList() {
        return pubUserDao.queryUserList();
    }

    /**
     * 查询菜单信息
     * @param userId
     * @return
     */
    @Override
    public List<PubMenu> selectMenuByUserId(Long userId) {
        return pubUserDao.selectMenuByUserId(userId);
    }
}
