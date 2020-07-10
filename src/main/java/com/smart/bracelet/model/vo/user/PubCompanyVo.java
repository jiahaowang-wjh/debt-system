package com.smart.bracelet.model.vo.user;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_company
 * @author 
 */
@Data
public class PubCompanyVo implements Serializable {
    private static final long serialVersionUID = -2770051200994240413L;
    /**
     * 公司ID
     */
    @NotNull(message = "公司ID不能为空")
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