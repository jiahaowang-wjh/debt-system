package com.smart.bracelet.enums;


/**
 * TODO:
 *
 * @author liuzq
 * @version 1.0
 * @date 2020/9/20
 **/
public enum DocumentPath {


    /**
     * Word模板
     * */
    WORD_TEMPLATE_CUMOUT("信息分析暨尽调协议（天泽系统）", "D:/doc/", "information.docx"),
    WORD_TEMPLATE("策划方案服务协议(天泽系统）", "D:/doc/", "planningPlan.docx"),
    WORD_TEMPLATE_TRANSFER("债权转让协议(资产系统)","D:/doc/","claimsTransfer.docx"),
    WORD_TEMPLATE_CONFIRM("债权转让确认书 （资产系统）","D:/doc/","claimsTransferConfirm.docx"),
    WORD_TEMPLATE_NOTICE("债权转让通知书 （资产系统）","D:/doc/","claimsTransferNotice.docx"),
    WORD_TEMPLATE_PROVE("债权确认书 （资产系统）","D:/doc/","claimsConfirm.docx"),
    WORD_TEMPLATE_LETTER("催款函 （资产系统）","D:/doc/","dunningLetter.docx"),
    WORD_TEMPLATE_CONSIG("委托代理销售合同1 （资产系统）","D:/doc/","proxyAgent.docx"),
    WORD_TEMPLATE_RECILIATION("和解协议 （资产系统）","D:/doc/","reconciliation.docx"),
    WORD_TEMPLATE_ONLINECONSIG("委托线上代理销售合同","D:/doc/","proxyAgentOnline.docx"),
    WORD_TEMPLATE_REPORT("收据（报备费）","D:/doc/","report.docx"),
    WORD_TEMPLATE_ADVISORY("收据（咨询服务费）","D:/doc/","advisory.docx"),
    WORD_TEMPLATE_PAYMENT("收据（预付款）","D:/doc/","prepaid.docx"),


//    WORD_TEMPLATE_CUMOUT("信息分析暨尽调协议（天泽系统）", "/root/upload/docFile/", "information.docx"),
//    WORD_TEMPLATE("策划方案服务协议(天泽系统）", "/root/upload/docFile/", "planningPlan.docx"),
//    WORD_TEMPLATE_TRANSFER("债权转让协议(资产系统)","/root/upload/docFile/","claimsTransfer.docx"),
//    WORD_TEMPLATE_CONFIRM("债权转让确认书 （资产系统）","/root/upload/docFile/","claimsTransferConfirm.docx"),
//    WORD_TEMPLATE_NOTICE("债权转让通知书 （资产系统）","/root/upload/docFile/","claimsTransferNotice.docx"),
//    WORD_TEMPLATE_PROVE("债权确认书 （资产系统）","/root/upload/docFile/","claimsConfirm.docx"),
//    WORD_TEMPLATE_LETTER("催款函 （资产系统）","/root/upload/docFile/","dunningLetter.docx"),
//    WORD_TEMPLATE_CONSIG("委托代理销售合同1 （资产系统）","/root/upload/docFile/","proxyAgent.docx"),
//    WORD_TEMPLATE_RECILIATION("和解协议 （资产系统）","/root/upload/docFile/","reconciliation.docx"),
//    WORD_TEMPLATE_ONLINECONSIG("委托线上代理销售合同","/root/upload/docFile/","proxyAgentOnline.docx"),
//    WORD_TEMPLATE_REPORT("收据（报备费）","/root/upload/docFile/","report.docx"),
//    WORD_TEMPLATE_ADVISORY("收据（咨询服务费）","/root/upload/docFile/","advisory.docx"),
//    WORD_TEMPLATE_PAYMENT("收据（预付款）","/root/upload/docFile/","prepaid.docx"),

    /**
     * pdf保存
     * */
    PDF_SAVE_CUMOUT("信息分析暨尽调协议（天泽系统）", "D:/doc/", ""),
    PDF_SAVE("策划方案服务协议(天泽系统）", "D:/doc/", ""),
    PDF_SAVE_TRANSFER("债权转让协议(资产系统)", "D:/doc/", ""),
    PDF_SAVE_CONFIRM("债权转让确认书 （资产系统）","D:/doc/",""),
    PDF_SAVE_NOTICE("债权转让通知书 （资产系统）","D:/doc/",""),
    PDF_SAVE_PROVE("债权确认书 （资产系统）","D:/doc/",""),
    PDF_SAVE_LETTER("催款函 （资产系统）","D:/doc/",""),
    PDF_SAVE_CONSIG("委托代理销售合同1 （资产系统）","D:/doc/",""),
    PDF_SAVE_RECILIATION("和解协议 （资产系统）","D:/doc/",""),
    PDF_SAVE_ONLINECONSIG("委托线上代理销售合同","D:/doc/",""),
    PDF_SAVE_REPORT("收据（报备费）","D:/doc/",""),
    PDF_SAVE_ADVISORY("收据（咨询服务费）","D:/doc/",""),
    PDF_SAVE_PAYMENT("收据（预付款）","D:/doc/",""),



//    PDF_SAVE_CUMOUT("信息分析暨尽调协议（天泽系统）", "/root/upload/docFile/", ""),
//    PDF_SAVE("策划方案服务协议(天泽系统）", "/root/upload/docFile/", ""),
//    PDF_SAVE_TRANSFER("债权转让协议(资产系统)", "/root/upload/docFile/", ""),
//    PDF_SAVE_CONFIRM("债权转让确认书 （资产系统）","/root/upload/docFile/",""),
//    PDF_SAVE_NOTICE("债权转让通知书 （资产系统）","/root/upload/docFile/",""),
//    PDF_SAVE_PROVE("债权确认书 （资产系统）","/root/upload/docFile/",""),
//    PDF_SAVE_LETTER("催款函 （资产系统）","/root/upload/docFile/",""),
//    PDF_SAVE_CONSIG("委托代理销售合同1 （资产系统）","/root/upload/docFile/",""),
//    PDF_SAVE_RECILIATION("和解协议 （资产系统）","/root/upload/docFile/",""),
//    PDF_SAVE_ONLINECONSIG("委托线上代理销售合同","/root/upload/docFile/",""),
//    PDF_SAVE_REPORT("收据（报备费）","/root/upload/docFile/",""),
//    PDF_SAVE_ADVISORY("收据（咨询服务费）","/root/upload/docFile/",""),
//    PDF_SAVE_PAYMENT("收据（预付款）","/root/upload/docFile/",""),
    ;



    private String name;
    private String path;
    private String fileName;

    DocumentPath(String name, String path, String fileName) {
        this.name = name;
        this.path = path;
        this.fileName = fileName;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getFileName() {
        return fileName;
    }
}
