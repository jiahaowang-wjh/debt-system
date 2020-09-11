package com.smart.bracelet.model;

import java.io.Serializable;

/**
 * bus_electron_userno
 * @author 
 */
public class BusElectronUserno implements Serializable {
    /**
     * 电子签id控制
     */
    private Integer userno;

    private static final long serialVersionUID = 1L;

    public Integer getUserno() {
        return userno;
    }

    public void setUserno(Integer userno) {
        this.userno = userno;
    }
}