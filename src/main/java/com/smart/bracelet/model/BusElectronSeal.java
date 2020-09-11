package com.smart.bracelet.model;

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
     * 乙方
     */
    private String partb;

    /**
     * 甲方类型
     */
    private String partaType;

    /**
     * 乙方类型
     */
    private String partbType;

    private String partaCard;

    private String partbCard;

    private String partaTel;

    private String partbTel;

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

    public String getPartb() {
        return partb;
    }

    public void setPartb(String partb) {
        this.partb = partb;
    }

    public String getPartaType() {
        return partaType;
    }

    public void setPartaType(String partaType) {
        this.partaType = partaType;
    }

    public String getPartbType() {
        return partbType;
    }

    public void setPartbType(String partbType) {
        this.partbType = partbType;
    }

    public String getPartaCard() {
        return partaCard;
    }

    public void setPartaCard(String partaCard) {
        this.partaCard = partaCard;
    }

    public String getPartbCard() {
        return partbCard;
    }

    public void setPartbCard(String partbCard) {
        this.partbCard = partbCard;
    }

    public String getPartaTel() {
        return partaTel;
    }

    public void setPartaTel(String partaTel) {
        this.partaTel = partaTel;
    }

    public String getPartbTel() {
        return partbTel;
    }

    public void setPartbTel(String partbTel) {
        this.partbTel = partbTel;
    }
}