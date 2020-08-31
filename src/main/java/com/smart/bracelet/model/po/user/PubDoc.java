package com.smart.bracelet.model.po.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotBlank;
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
     * 文档路径
     */
    @NotBlank(message = "文档路径不能为空")
    private String docPath;

    /**
     * 备注
     */
    private String note;


}