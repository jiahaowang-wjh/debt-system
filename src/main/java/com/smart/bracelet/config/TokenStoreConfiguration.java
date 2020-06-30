package com.smart.bracelet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author junyunxiao
 * @version 1.0
 * @Description: 描述信息
 * @date 2020/4/13 14:16
 */
@Configuration
public class TokenStoreConfiguration {

    @Bean
    public RedisTokenStore tokenStore(RedisConnectionFactory redisConnectionFactory) {
        return new RedisTokenStore(redisConnectionFactory);
    }



}
