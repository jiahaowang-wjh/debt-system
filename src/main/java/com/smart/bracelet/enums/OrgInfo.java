package com.smart.bracelet.enums;

public enum OrgInfo {
    ELEC_AA("25f2254c6ad441f4939b70ccf696c1f9", "深圳市金隆盛投资管理有限公司","914403003595944902","0abac95475e94b0f917b33eec11628b8","6b985686-6be1-43a7-8443-3c3894eee6e9"),
    ELEC_BB("e02d0ded00224fe089fa02ab4fe93c84", "深圳市方博商贸管理有限公司","91440300MA5G44JB4K","f832e7ba6803442bb9f00d982e8e7e9d","50fc5c05-3517-475c-a345-0905ab1510ba");

    OrgInfo(String orgid, String orgname, String orgCode, String accountId, String sealId) {
        this.orgid = orgid;
        this.orgname = orgname;
        this.orgCode = orgCode;
        this.accountId = accountId;
        this.sealId = sealId;
    }

    /**
     * 组织id
     */
    private String orgid;
    /**
     * 组织名称
     */
    private String orgname;
    /**
     * 组织编码
     */
    private String orgCode;

    private String accountId;

    private String sealId;

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getSealId() {
        return sealId;
    }

    public void setSealId(String sealId) {
        this.sealId = sealId;
    }
}
