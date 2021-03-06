package com.smart.bracelet.model.vo.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * pub_menu
 *
 * @author
 */
@Data
public class PubMenuVo implements Serializable {
    private static final long serialVersionUID = -4995180925435259866L;
    /**
     * 菜单ID
     */
    @NotNull(message = "菜单ID不能为空")
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
    private Integer menuOrder;

    /**
     * 父级ID
     */
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