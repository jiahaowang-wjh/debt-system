package com.smart.bracelet.model.vo.user;

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
public class PubDocVo implements Serializable {
    private static final long serialVersionUID = 7256140036258488800L;
    /**
     * 文档ID
     */
    @NotNull(message = "文档ID不能为空")
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