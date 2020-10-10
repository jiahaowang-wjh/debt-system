package com.smart.bracelet.model.po.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_doc
 *
 * @author
 */
@Data
public class PubDoc implements Serializable {
    private static final long serialVersionUID = 7144959776865946006L;
    /**
     * 文档ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long docId;

    /**
     * 文档名
     */
    @NotBlank(message = "文档名不能为空")
    String docName;

    /**
     * 文档路径
     */
    @NotBlank(message = "文档路径不能为空")
    private String docPath;

     /**
     * 合同编号
     */
    String contract;

    /**
     * 报备ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long reportId;

    /**
     * 解债ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long debtId;

    /**
     * 资产ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long propertId;

    /**
     * 备注
     */
    private String note;

    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "公司ID不能为空")
    private Long comId;
    /**
     * 文档类型
     */
    String docType;
}