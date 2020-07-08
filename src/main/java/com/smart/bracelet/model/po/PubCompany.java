package com.smart.bracelet.model.po;

import lombok.Data;

import java.io.Serializable;

/**
 * pub_company
 * @author 
 */
@Data
public class PubCompany implements Serializable {
    private static final long serialVersionUID = -3811838743935049670L;
    /**
     * 公司ID
     */
    private Long companyId;

    /**
     * 区域id
     */
    private Long areaId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司类型
     */
    private String companyType;

    /**
     * 公司法人
     */
    private String companyLeperson;

    /**
     * 公司联系电话
     */
    private String companyTel;


}