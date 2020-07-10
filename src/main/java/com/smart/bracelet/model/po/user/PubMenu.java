package com.smart.bracelet.model.po.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_menu
 * @author 
 */
@Data
public class PubMenu implements Serializable {
    private static final long serialVersionUID = -8909321750533993249L;
    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 菜单名
     */
    @NotBlank(message = "菜单名不能为空")
    private String menuName;

    /**
     * 菜单地址
     */
    @NotBlank(message = "菜单地址不能为空")
    private String menuUrl;

    /**
     * 排序
     */
    @NotNull(message = "排序值不能为空")
    private Integer menuOrder;

    /**
     * 父级ID
     */
    @NotNull(message = "父级Id不能为空")
    private Long prantId;

    /**
     * 是否有效
     */
    private String isenable;

    /**
     * 备注
     */
    private String note;

}