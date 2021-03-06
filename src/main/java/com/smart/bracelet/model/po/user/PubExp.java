package com.smart.bracelet.model.po.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * pub_exp
 *
 * @author
 */
@Data
public class PubExp implements Serializable {
    private static final long serialVersionUID = 881322794793012491L;
    /**
     * 公式ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long expId;

    /**
     * 公式类型
     */
    @NotBlank(message = "公式类型不能为空")
    private String expType;

    /**
     * 公式编号
     */
    @NotBlank(message = "公式编号不能为空")
    private String expCode;

    /**
     * 公式
     */
    @NotBlank(message = "公式不能为空")
    private String exp;

    /**
     * 参数
     */
    @NotBlank(message = "参数不能为空")
    private String paramter;
}