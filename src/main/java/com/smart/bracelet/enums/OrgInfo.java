package com.smart.bracelet.enums;

public enum OrgInfo {
    ELEC_AA("AAA", "深圳市金隆盛投资管理有限公司","914403003595944902"),
    ELEC_BB("BBB", "深圳市方博商贸管理有限公司","91440300MA5G44JB4K");

    OrgInfo(String orgid, String orgname, String orgCode) {
        this.orgid = orgid;
        this.orgname = orgname;
        this.orgCode = orgCode;
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

}
