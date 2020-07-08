package com.smart.bracelet.model.po;

import lombok.Data;

import java.io.Serializable;

/**
 * pub_exp
 * @author 
 */
@Data
public class PubExp implements Serializable {
    private static final long serialVersionUID = 881322794793012491L;
    /**
     * 公式ID
     */
    private Long expId;

    /**
     * 公式类型
     */
    private String expType;

    /**
     * 公式编号
     */
    private String expCode;

    /**
     * 公式
     */
    private String exp;

    /**
     * 参数
     */
    private String paramter;
}