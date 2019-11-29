package cn.yubin.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {

    private static JedisPool jedisPool;

    static {

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(15);//闲时最大的数量
        poolConfig.setMaxTotal(100); //最大有100个
        poolConfig.setMinIdle(5);//最小闲时的数量
        jedisPool = new JedisPool(poolConfig, "192.168.48.200", 6379);

    }

    public static Jedis getJedis() {

        return jedisPool.getResource();

    }
//    public static Jedis close() {
//        return jedisPool.returnResource(jedisPool.getResource());
//    }
}