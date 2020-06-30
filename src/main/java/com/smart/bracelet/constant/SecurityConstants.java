package com.smart.bracelet.constant;

/**
 * @author junyunxiao
 * @version 1.0
 * @Description: 描述信息
 * @date 2020/4/9 15:11
 */
public interface SecurityConstants {


    /**
     * 当请求需要身份认证时，默认跳转的url
     *
     * @see
     */
    String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";

    /**
     * 默认的用户名密码登录请求处理url
     */
    String DEFAULT_SIGN_IN_PROCESSING_URL_FORM = "/authentication/form";

    /**
     * 用户ID字段
     */
    String DETAILS_USER_ID = "user_id";

    /**
     * 用户名字段
     */
    String DETAILS_USERNAME = "username";

    /**
     * 用户部门字段
     */
    String DETAILS_DEPT_ID = "dept_id";

    /**
     * 租户ID 字段
     */
    String DETAILS_TENANT_ID = "tenant_id";

    /**
     * 协议字段
     */
    String DETAILS_LICENSE = "license";

    /**
     * 头像
     */
    String DEFAULT_AVATAR="userAvatar";
}
