package com.smart.bracelet.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * pub_doc
 * @author 
 */
@Data
public class PubDocVo implements Serializable {
    private static final long serialVersionUID = 7256140036258488800L;
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