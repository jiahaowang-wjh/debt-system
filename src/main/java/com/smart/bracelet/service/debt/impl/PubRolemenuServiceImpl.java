package com.smart.bracelet.service.debt.impl;

import com.smart.bracelet.dao.debt.PubRolemenuDao;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.model.po.user.PubRolemenu;
import com.smart.bracelet.service.debt.PubRolemenuService;
import com.smart.bracelet.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class PubRolemenuServiceImpl implements PubRolemenuService {

    @Autowired
    private PubRolemenuDao pubRolemenuDao;

    @Override
    @Transactional(noRollbackFor = Exception.class)
    public int addListRolemenu(String menuId, Long roleId) throws CustomerException {
        List<PubRolemenu> list = new ArrayList<>();
        try {
            List<String> menuIds = Arrays.asList(menuId.split(","));
            for (String item : menuIds) {
                PubRolemenu pubRolemenu = new PubRolemenu();
                pubRolemenu.setRolemenuId(IdUtils.nextId());
                pubRolemenu.setMenuId(Long.parseLong(item));
                pubRolemenu.setRoleId(roleId);
                list.add(pubRolemenu);
            }
            return pubRolemenuDao.addListRolemenu(list);
        } catch (Exception e) {
            log.error("异常信息:{}", e.getMessage());
            throw new CustomerException("新增失败");
        }
    }
}
