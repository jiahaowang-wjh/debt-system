package com.smart.bracelet.model.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_auth
 * @author 
 */
@Data
public class PubAuthVo implements Serializable {
    private static final long serialVersionUID = 4529113546954065228L;
    /**
     * 权限ID
     */
    @NotNull(message = "权限ID不能为空")
    private Long authId;

    /**
     * 权限名
     */
    private String authname;

    /**
     * 接口名称
     */
    private String interfacename;

    /**
     * 备注
     */
    private String note;


}