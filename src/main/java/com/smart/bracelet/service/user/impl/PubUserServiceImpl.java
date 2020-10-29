package com.smart.bracelet.service.user.impl;

import com.alibaba.fastjson.JSON;
import com.smart.bracelet.dao.user.PubUserDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.*;
import com.smart.bracelet.model.vo.user.PersonOnUserOnComVo;
import com.smart.bracelet.model.vo.user.PubUserVo;
import com.smart.bracelet.model.vo.user.UserMenu;
import com.smart.bracelet.service.user.PubCompanyService;
import com.smart.bracelet.service.user.PubDictionService;
import com.smart.bracelet.service.user.PubPersonService;
import com.smart.bracelet.service.user.PubUserService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class PubUserServiceImpl implements PubUserService {


    @Autowired
    private PubUserDao pubUserDao;

    @Autowired
    private PubDictionService pubDictionService;

    @Autowired
    private PubCompanyService pubCompanyService;

    @Autowired
    private PubPersonService pubPersonService;

    /**
     * 通过ID删除用户信息
     *
     * @param userId
     * @return
     * @throws CustomerException
     */
    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long userId) throws CustomerException {
        try {
            int i = pubUserDao.deleteByPrimaryKey(userId);
            log.info("删除用户信息成功,首映影响行数:{}", i);
            return i;
        } catch (Exception e) {
            log.error("删除用户信息失败,异常信息:", e.getMessage());
            throw new CustomerException("删除用户信息失败");
        }
    }

    /**
     * 新增用户信息
     *
     * @param record
     * @return
     * @throws CustomerException
     */
    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int insertSelective(PubUser record) throws CustomerException {
        try {
            record.setUserId(IdUtils.nextId());
            record.setPasswordMd5(new BCryptPasswordEncoder().encode(record.getPasswordMd5()));
            //是否有效,0无效,1有效,默认有效
            record.setIsenable("1");
            int i = pubUserDao.insertSelective(record);
            log.info("用户信息添加成功,受影响行数:{}", i);
            return i;
        } catch (Exception e) {
            log.error("用户信息添加失败,异常信息:{}", e.getMessage());
            throw new CustomerException("用户信息添加失败");
        }
    }

    /**
     * 通过Id查询用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public PubUser selectByPrimaryKey(Long userId) {
        return pubUserDao.selectByPrimaryKey(userId);
    }

    /**
     * 修改用户信息
     *
     * @param record
     * @return
     * @throws CustomerException
     */
    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(PubUserVo record) throws CustomerException {
        try {
            int i = pubUserDao.updateByPrimaryKeySelective(record);
            log.info("修改用户信息成功,受影响行数:{}", i);
            return i;
        } catch (Exception e) {
            log.error("修改用户信息失败,异常信息:{}", e.getMessage());
            throw new CustomerException("修改用户信息失败");
        }
    }

    @Override
    public PubUser selectUserInfoAccount(String pubUser) {
        return pubUserDao.selectUserInfoAccount(pubUser);
    }

    /**
     * 查询用户权限
     *
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
     *
     * @param userId
     * @return
     */
    @Override
    public List<PubMenu> selectMenuByUserId(Long userId) {
        return pubUserDao.selectMenuByUserId(userId);
    }

    @Override
    public List<PubAuth> selectAuthByRoleId(Long roleId, Long menuId) {
        return pubUserDao.selectAuthByRoleId(roleId, menuId);
    }

    /**
     * 修改密码
     *
     * @param outPwd   旧密码
     * @param newPwdA  新密码
     * @param newPwdB  重复确认新密码
     * @param personId 用户ID
     * @return
     * @throws CustomerException
     */
    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updateUserPwd(String outPwd, String newPwdA, String newPwdB, Long personId) throws CustomerException {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        try {
            PubUser pubUser = selectByPrimaryKey(personId);
            if (!bCryptPasswordEncoder.matches(outPwd, pubUser.getPasswordMd5())) {
                throw new CustomerException("原密码输入错误");
            }
            if (!newPwdA.equals(newPwdB)) {
                throw new CustomerException("两次密码不一致");
            }
            int updateUserPwd = pubUserDao.updateUserPwd(bCryptPasswordEncoder.encode(newPwdA), personId);
            log.info("修改密码成功,受影响行数:{}", updateUserPwd);
            return updateUserPwd;
        } catch (CustomerException e) {
            log.error("修改密码失败,异常信息:{}", e.getMessage());
            throw new CustomerException("修改密码失败:" + e.getMessage());
        }
    }

    /**
     * 批量删除用户
     *
     * @param userIds
     * @return
     */
    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int delUserList(Long[] userIds) throws CustomerException {
        try {
            int delUserList = pubUserDao.delUserList(userIds);
            log.info("批量删除用户成功,受影响行数:", delUserList);
            return delUserList;
        } catch (Exception e) {
            log.error("批量删除用户失败,异常信息:{}", e.getMessage());
            throw new CustomerException("批量删除用户失败");
        }
    }

    /**
     * 人员公司用户信息展示
     *
     * @return
     */
    @Override
    public List<PersonOnUserOnCom> queryList() {
        List<PersonOnUserOnCom> personOnUserOnComVos = pubUserDao.queryList();
        return personOnUserOnComVos;
    }

    @Override
    public Long selectUserComId(Long userId) {
        Long aLong = pubUserDao.selectUserComId(userId);
        return aLong;
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int delListPerson(Long[] ids) throws CustomerException {
        try {
            int i = pubUserDao.delListPerson(ids);
            return i;
        } catch (Exception e) {
            log.error("异常信息:{}", e.getMessage());
            throw new CustomerException("批量删除失败");
        }
    }

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int updatePerson(PersonOnUserOnComVo personOnUserOnComVo) throws CustomerException {
        try {
            int i = pubUserDao.updatePerson(personOnUserOnComVo);
            return i;
        } catch (Exception e) {
            log.error("异常信息:{}", e.getMessage());
            throw new CustomerException("更新失败");
        }
    }

    @Override
    public int addComm(Commodity commodity, String note) throws CustomerException {
        try {
            String comm = JSON.toJSONString(commodity);
            PubDiction pubDiction = new PubDiction();
            pubDiction.setDictionId(IdUtils.nextId());
            pubDiction.setDictionDis(comm);
            pubDiction.setNote(note);
            pubDiction.setDictionType("COMMODITY");
            int i = pubDictionService.insertSelective(pubDiction);
            log.info("新增商品成功，受影响行数：{}", i);
            return i;
        } catch (CustomerException e) {
            log.error("新增商品失败,异常信息：{}", e.getMessage());
            throw new CustomerException("新增商品失败");
        }
    }

    @Override
    public int insertPort(ComPerUserInfo comPerUserInfo) throws CustomerException {
        Long comId = IdUtils.nextId();
        Long perId = IdUtils.nextId();
        int insertSelective = 0;
        int insertSelective1 = 0;
        try {

            PubCompany pubCompany = pubCompanyService.selectByNameMax(comPerUserInfo.getCompanyNameMax());
            if (pubCompany == null) {
                //新增公司信息
                PubCompany company = new PubCompany();
                company.setCompanyId(comId);
                company.setAreaId(comPerUserInfo.getAreaId());
                company.setCompanyName(comPerUserInfo.getCompanyName());
                company.setCompanyNameMax(comPerUserInfo.getCompanyNameMax());
                company.setCompanyType(comPerUserInfo.getCompanyType());
                company.setCompanyLeperson(comPerUserInfo.getCompanyLeperson());
                company.setCompanyTel(comPerUserInfo.getCompanyTel());
                insertSelective = pubCompanyService.insertSelective(company);
                log.info("新增公司信息成功,受影响行数：{}", insertSelective);
            }
            PubPerson pubPerson = new PubPerson();
            if (pubCompany != null) {
                pubPerson.setCompanyId(pubCompany.getCompanyId());
            } else {
                pubPerson.setCompanyId(comId);
            }
            PubPerson pubPerson1 = pubPersonService.selectByPrimaryName(comPerUserInfo.getPersonName());
            if (pubPerson1 == null) {
                pubPerson.setPersonId(perId);
                pubPerson.setPersonName(comPerUserInfo.getPersonName());
                pubPerson.setPersonType(comPerUserInfo.getPersonType());
                pubPerson.setSex(comPerUserInfo.getSex());
                pubPerson.setAge(comPerUserInfo.getAge());
                pubPerson.setTel(comPerUserInfo.getTel());
                pubPerson.setNote(comPerUserInfo.getPerNote());
                insertSelective1 = pubPersonService.insertSelective(pubPerson);
                log.info("新增人员信息成功，受影响行数：{}", insertSelective1);
            }
            PubUser pubUser = new PubUser();
            if (pubPerson1 == null) {
                pubUser.setPersonId(perId);
            } else {
                pubUser.setPersonId(pubPerson1.getPersonId());
            }
            pubUser.setRoleId(comPerUserInfo.getRoleId());
            pubUser.setLoginName(comPerUserInfo.getLoginName());
            pubUser.setPasswordMd5(comPerUserInfo.getPasswordMd5());
            pubUser.setIsenable(comPerUserInfo.getIsenable());
            pubUser.setUserType(comPerUserInfo.getUserType());
            pubUser.setNote(comPerUserInfo.getUserNote());
            int insertSelective2 = insertSelective(pubUser);
            log.info("新增用户信息成功，受影响行数：{}", insertSelective2);
            return insertSelective + insertSelective1 + insertSelective2;
        } catch (Exception e) {
            log.error("端口新增失败，异常信息：{}", e.getMessage());
            throw new CustomerException("端口新增失败");
        }
    }
}
