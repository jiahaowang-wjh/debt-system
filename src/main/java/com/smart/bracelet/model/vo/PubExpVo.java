package com.smart.bracelet.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * pub_exp
 * @author 
 */
@Data
public class PubExpVo implements Serializable {
    private static final long serialVersionUID = 7154426227468356191L;
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