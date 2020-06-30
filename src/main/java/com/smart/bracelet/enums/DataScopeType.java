package com.smart.bracelet.enums;

/**
 * @author junyunxiao
 * @version 1.0
 * @Description: 描述信息
 * @date 2020/4/15 18:17
 */
public enum DataScopeType {

    /**
     * 数据权限类型:0.全部，1.自定义，2.本部门及其以下，3.本部门
     */
    ALL("0"),

    /**
     * 数据权限类型:0.全部，1.自定义，2.本部门及其以下，3.本部门
     */
    CUSTOMER("1"),

    /**
     * 数据权限类型:0.全部，1.自定义，2.本部门及其以下，3.本部门
     */
    OWN_CHILD_LEVEL("2"),

    /**
     * 数据权限类型:0.全部，1.自定义，2.本部门及其以下，3.本部门
     */
    OWN_LEVEL("3")
    ;

    private String type;

    DataScopeType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
