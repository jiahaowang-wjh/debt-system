package com.smart.bracelet.model.utilesBean;

import lombok.Data;

/**
 * 验证码实体类
 */
@Data
public class VerifyCode {

    private String code;

    private byte[] imgBytes;

    private long expireTime;
}
