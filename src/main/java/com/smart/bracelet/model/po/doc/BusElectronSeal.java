package com.smart.bracelet.model.po.doc;

import lombok.Data;

import java.io.Serializable;

/**
 * bus_electron_seal
 * @author 
 */
@Data
public class BusElectronSeal {
    /**
     * 电子章ID
     */
    private Long electronSealId;

    /**
     * 文档ID
     */
    private Long docId;

    /**
     * 文档类型
     */
    private String docType;


    /**
     * 甲方类型
     */
    private String partaType;

    /**
     * 甲方
     */
    private String parta;

    private String partaCard ;

    private String partaTel;

    private String flowId;

    private String fileUrl;

    private String filePath;


}