package com.smart.bracelet.model.doc;

import java.io.Serializable;

/**
 * bus_electron_seal
 * @author
 */
public class BusElectronSeal implements Serializable {
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
     * 甲方
     */
    private String parta;

    /**
     * 甲方类型
     */
    private String partaType;

    private String partaCard;

    private String partaTel;

    private String flowId;

    private String fileUrl;

    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    private static final long serialVersionUID = 1L;

    public Long getElectronSealId() {
        return electronSealId;
    }

    public void setElectronSealId(Long electronSealId) {
        this.electronSealId = electronSealId;
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getParta() {
        return parta;
    }

    public void setParta(String parta) {
        this.parta = parta;
    }

    public String getPartaType() {
        return partaType;
    }

    public void setPartaType(String partaType) {
        this.partaType = partaType;
    }

    public String getPartaCard() {
        return partaCard;
    }

    public void setPartaCard(String partaCard) {
        this.partaCard = partaCard;
    }

    public String getPartaTel() {
        return partaTel;
    }

    public void setPartaTel(String partaTel) {
        this.partaTel = partaTel;
    }

}