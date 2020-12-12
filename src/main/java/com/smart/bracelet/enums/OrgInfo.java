package com.smart.bracelet.enums;

public enum OrgInfo {
    ELEC_AA("8a1a02daccb44ab78cbbce932b7c0eac", "深圳市金隆盛投资管理有限公司","914403003595944902","4b4e2919558d4d9399fe57afb8463411","cb05e198-5bc7-498e-8198-924d186ff7d6"),
    ELEC_BB("d2cb84b4bd844cf08773ba85a004e4e7", "深圳市方博商贸管理有限公司","91440300MA5G44JB4K","a616445b152c40c7bf90ab1b25380cae","830133a8-fafd-444d-ac43-4168a472462f"),
    ELEC_CC("173028e7c6d749d29d0ca76e8cd30f92", "重庆米呀米电子商务有限公司","91500107MA616WHU2M","b0f9ececb7d94431a59549945979d1de","81233db1-81dd-480a-b0fb-dfa27ef446ae");

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
