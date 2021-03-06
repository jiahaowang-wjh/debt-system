package com.smart.bracelet.model.po.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * pub_menu
 *
 * @author
 */
@Data
public class PubMenuShow implements Serializable {
    private static final long serialVersionUID = -8909321750533993249L;
    /**
     * 菜单ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long menuId;

    /**
     * 菜单名
     */
    private String menuName;

    /**
     * 菜单地址
     */
    private String menuUrl;

    /**
     * 排序
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer menuOrder;

    /**
     * 父级ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long prantId;

    /**
     * 是否有效
     */
    private String isenable;

    /**
     * 备注
     */
    private String note;

    /**
     * 权限名
     */
    List<Auth> list;


    List<PubMenuShow> childTreeDto;

}