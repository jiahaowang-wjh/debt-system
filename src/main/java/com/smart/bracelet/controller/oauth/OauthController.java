package com.smart.bracelet.controller.oauth;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author junyunxiao
 * @version 1.0
 * @Description: 描述信息
 * @date 2020/4/13 15:02
 */
@RequestMapping("/api/oauth/")
@RestController
@Slf4j
public class OauthController {

    @GetMapping("checkToken")
    public Principal checkToken(Principal principal){
        if (log.isDebugEnabled()){
            log.debug("请求数据"+ JSONUtil.toJsonStr(principal));
        }
        return principal;
    }
}
