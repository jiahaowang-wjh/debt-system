package com.smart.bracelet.enums;

/**
 * TODO:
 *
 * @author liuzq
 * @version 1.0
 * @date 2020/9/20
 **/
public enum DocumentPath {

//    /**
//     * Word模板
//     * */
    WORD_TEMPLATE("策划方案服务协议(天泽系统）", "D:/doc/", "1.策划方案服务协议(天泽系统）.docx"),
    WORD_TEMPLATE2("收据（报备费）", "D:/doc/", "收据（报备费）.docx"),
    /**
     * pdf保存
     * */
    PDF_SAVE("策划方案服务协议(天泽系统）", "D:/doc/", "")
//    WORD_TEMPLATE("策划方案服务协议(天泽系统）", "/home/doc/", "1.策划方案服务协议(天泽系统）.docx"),
//    /**
//     * pdf保存
//     * */
//    PDF_SAVE("策划方案服务协议(天泽系统）", "/home/pdf/", "")

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
