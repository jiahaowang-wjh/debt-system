package com.smart.bracelet.model.vo.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class UserMenu {

    /**
     * 用户ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long userId;
    /**
     * 登录名
     */
    String loginName;
    /**
     * 角色名
     */
    String roleName;
    /**
     * 菜单名
     */
    String menuName;
    /**
     * 菜单ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    Long menuId;
    /**
     * 菜单地址
     */
    String menuurl;
    /**
     * 是否有效
     */
    String isenable;

}
