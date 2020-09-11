package com.smart.bracelet.model;

import java.io.Serializable;

/**
 * bus_eletron_user
 * @author 
 */
public class BusEletronUser implements Serializable {
    /**
     * 个人帐号ID
     */
    private String acctId;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 身份证号
     */
    private String userCard;

    /**
     * 电话
     */
    private String userTel;

    private static final long serialVersionUID = 1L;

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }
}