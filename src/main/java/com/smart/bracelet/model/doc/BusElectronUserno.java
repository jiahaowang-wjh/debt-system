package com.smart.bracelet.model.doc;

import java.io.Serializable;

/**
 * bus_electron_userno
 * @author
 */
public class BusElectronUserno implements Serializable {
    public Long getUserno() {
        return userno;
    }

    public void setUserno(Long userno) {
        this.userno = userno;
    }

    public String getNotype() {
        return notype;
    }

    public void setNotype(String notype) {
        this.notype = notype;
    }

    public Integer getIdno() {
        return idno;
    }

    public void setIdno(Integer idno) {
        this.idno = idno;
    }

    /**
     * 电子签id控制
     */
    private Long userno;
    private String notype;
    private Integer idno;

    private static final long serialVersionUID = 1L;


}