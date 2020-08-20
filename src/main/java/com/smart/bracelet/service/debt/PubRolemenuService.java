package com.smart.bracelet.service.debt;
import com.smart.bracelet.exception.CustomerException;


public interface PubRolemenuService {

    int addListRolemenu(String menuId,Long roleId) throws CustomerException;

}
