package com.smart.bracelet.enums;

public enum DocCode {

    /**
     * 录入费发票
     */
    INPUT_FEE("录入费发票", "01",false,1),

    CONSULTING_SERVICE_FEE("咨询服务费发票", "02",false,1),

    PAYMENT_FEE("货款费发票", "03",false,1),

    AGREE_ON("信息分析暨尽调协议", "04",true,3),

    PLAN_SERVICE_AGREEMENT("策划方案服务协议", "05",false,7),

    ASSIGNMENT_AGREEMENT("债权转让协议", "06",false,6),

    ASSIGNMENT_CONFIRMATION("债权转让确认书", "07",false,1),

    ASSIGNMENT_NOTICE("债权转让通知书", "08",false,1),

    ASSIGNMENT_CONFIRM("债权确认书", "09",false,1),

    COLLECTION_LETTER("催款函", "10",false,1),

    SALES_CONTRACT("委托代理销售合同", "11",false,1),

    SETTLEMENT_AGREEMENT("和解协议", "12",false,1);

    /**
     * 文档名称
     */
    private String docName;
    /**
     * 文档编码
     */
    private String docCode;
    /**
     * 骑缝章
     */
    private Boolean pageSale;
    /**
     * 页数
     */
    private int pagesize;

    DocCode(String docName, String docCode, Boolean pageSale,int pagesize) {
        this.docName = docName;
        this.docCode = docCode;
        this.pageSale = pageSale;
        this.pagesize = pagesize;
    }

    public String getDocName() {
        return docName;
    }

    public String getDocCode() {
        return docCode;
    }

    public Boolean getPageSale() {
        return pageSale;
    }
    public int getPagesize() {
        return pagesize;
    }
}
