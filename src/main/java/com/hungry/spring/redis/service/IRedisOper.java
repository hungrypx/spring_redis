package com.hungry.spring.redis.service;

import java.util.Set;

public interface IRedisOper {
     boolean set(final String key, String value);
     boolean set(final String key, String value, Long expireTime);
     boolean exists(final String key);
     Object get(final String key);
     void add(String key, String value);
     Set<String> setMembers(String key);
     boolean hSet(String key, String hashKey, String value);
     Object hGet(String key, Object hashKey);
}
