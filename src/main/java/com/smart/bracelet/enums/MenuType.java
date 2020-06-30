package com.smart.bracelet.enums;

/**
 * @author junyunxiao
 * @version 1.0
 * @Description: 描述信息
 * @date 2020/4/15 17:08
 */
public enum MenuType {

    /**
     * 菜单类型：0.目录，1.菜单，2.按钮
     */
    CATALOG("0"),

    /**
     * 菜单类型：0.目录，1.菜单，2.按钮
     */
    MENU("1"),

    /**
     * 菜单类型：0.目录，1.菜单，2.按钮
     */
    PERMISSION("2")
    ;


    /**
     * 类型
     */
    private String type;

    MenuType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
