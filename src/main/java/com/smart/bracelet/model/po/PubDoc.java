package com.smart.bracelet.model.po;

import lombok.Data;

import java.io.Serializable;

/**
 * pub_doc
 * @author 
 */
@Data
public class PubDoc implements Serializable {
    private static final long serialVersionUID = 7144959776865946006L;
    /**
     * 文档ID
     */
    private Long docId;

    /**
     * 文档路径
     */
    private String docPath;

    /**
     * 备注
     */
    private String note;


}