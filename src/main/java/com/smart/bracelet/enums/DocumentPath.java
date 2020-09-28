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
    WORD_TEMPLATE_CUMOUT("信息分析暨尽调协议（天泽系统）", "D:/doc/", "0.信息分析暨尽调协议（天泽系统）.docx"),
    WORD_TEMPLATE("策划方案服务协议(天泽系统）", "D:/doc/", "1.策划方案服务协议(天泽系统）.docx"),
    WORD_TEMPLATE_TRANSFER("债权转让协议(资产系统)","D:/doc/","2.债权转让协议1（资产系统）.docx"),
    WORD_TEMPLATE_CONFIRM("债权转让确认书 （资产系统）","D:/doc/","3.债权转让确认书 （资产系统）.docx"),
    WORD_TEMPLATE_NOTICE("债权转让通知书 （资产系统）","D:/doc/","4.债权转让通知书 （资产系统）.docx"),
    WORD_TEMPLATE_PROVE("债权确认书 （资产系统）","D:/doc/","5.债权确认书 （资产系统）.docx"),
    WORD_TEMPLATE_LETTER("催款函 （资产系统）","D:/doc/","6.催款函 （资产系统）.docx"),
    WORD_TEMPLATE_CONSIG("委托代理销售合同1 （资产系统）","D:/doc/","7.委托代理销售合同1 （资产系统）.docx"),
    WORD_TEMPLATE_RECILIATION("和解协议 （资产系统）","D:/doc/","9.和解协议 （资产系统）.docx"),
    WORD_TEMPLATE_ONLINECONSIG("委托线上代理销售合同(1)","D:/doc/","14.委托线上代理销售合同(1).docx"),


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
    PDF_SAVE_ONLINECONSIG("委托线上代理销售合同(1)","D:/doc/",""),
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
