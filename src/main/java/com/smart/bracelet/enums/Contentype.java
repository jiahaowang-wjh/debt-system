package com.smart.bracelet.enums;

/**
 * @author junyunxiao
 * @version 1.0
 * @Description: 描述信息
 * @date 2019/12/9 17:44
 */
public enum Contentype {

    /**
     * Json
     */
    JSON("application/json;charset=UTF-8"),
    ;


    /**
     * 类型
     */
    private String type;

    Contentype(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
