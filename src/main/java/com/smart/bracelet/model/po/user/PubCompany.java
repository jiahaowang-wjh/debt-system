package com.smart.bracelet.model.po.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * pub_company
 *
 * @author
 */
@Data
public class PubCompany implements Serializable {
    private static final long serialVersionUID = -3811838743935049670L;
    /**
     * 公司ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long companyId;

    /**
     * 区域id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "区域id不能为空")
    private Long areaId;

    /**
     * 公司名称
     */
    @NotBlank(message = "公司名称不能为空")
    private String companyName;

    /**
     * 公司类型
     */
    @NotBlank(message = "公司类型不能为空")
    private String companyType;

    /**
     * 公司法人
     */
    @NotBlank(message = "公司法人不能为空")
    private String companyLeperson;

    /**
     * 公司联系电话
     */
    @NotBlank(message = "公司联系电话不能为空")
    private String companyTel;

    /**
     * 公司名称缩写（大写）
     */
    @NotBlank(message = "公司名称缩写不能为空")
    private String companyNameMax;

    /**
     * 地区信息集合
     */
    String areas;


}