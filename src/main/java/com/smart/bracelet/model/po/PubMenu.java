package com.smart.bracelet.model.po;

import lombok.Data;

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
    private String menuname;

    /**
     * 菜单地址
     */
    private String menuurl;

    /**
     * 排序
     */
    private Integer menuorder;

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