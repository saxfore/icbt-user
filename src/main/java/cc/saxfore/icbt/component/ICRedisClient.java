package cc.saxfore.icbt.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 项目名称：icbt-user
 * 类 名 称：ICRedisClient
 * 类 描 述：TODO
 * 创建时间：2019/9/6 5:05 PM
 * 创 建 人：wangjiang
 */
@Component
public class ICRedisClient {

    @Autowired
    StringRedisTemplate redisTemplate;

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, String field, Object value) {
        redisTemplate.opsForHash().put(key, field, value);
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public Object get(String key, String field) {
        return redisTemplate.opsForHash().get(key, field);
    }

}
