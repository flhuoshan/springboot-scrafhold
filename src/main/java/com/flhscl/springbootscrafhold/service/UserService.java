package com.flhscl.springbootscrafhold.service;

import com.flhscl.springbootscrafhold.entity.datasource1.User;
import com.flhscl.springbootscrafhold.mapper.datasource1.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="http://flcoder.com">cl</a>
 * @version 1.0 & 2017/9/11
 * @since 1.0
 * To change this template use File | Settings | Editor | File and Code Templates
 * Description:
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 保存消息，保存时候不插入缓存
     * @param user
     * @return
     */
    public int saveUser(User user){
        return userMapper.insert(user);
    }


    /**
     * 删除记录，策略是先删除数据库记录，再检查缓存中是否有记录，有则删除，否则不处理
     * @param userId
     * @return
     */
    public int deleteUser(Integer userId){
        int deletedNum = userMapper.deleteByPrimaryKey(userId);
        if(deletedNum == 0){
            return deletedNum;
        }
        if(redisTemplate.hasKey(userId)){
            redisTemplate.delete(userId);
            log.info("删除操作时删除了userId为{}的缓存记录", userId);
        }
        return deletedNum;
    }

    /**
     * 更新记录，策略是先更新数据库记录，再检查缓存中是否有记录，有则删除，否则不处理
     * @param user
     * @return
     */
    public int updateUser(User user){
        int updatedNum = userMapper.updateByPrimaryKeySelective(user);
        if(updatedNum == 0){
            return updatedNum;
        }
        Integer userId = user.getId();
        if(redisTemplate.hasKey(userId)){
            redisTemplate.delete(userId);
            log.info("更新操作时删除了userId为{}的缓存记录", userId);
        }
        return updatedNum;

    }

    /**
     * 查找记录，先检查缓存中是否有该数据，有则返回数据，无则从关系数据库查出并插入到缓存
     * @param userId
     * @return
     */
    public User selectUser(Integer userId){
        ValueOperations<Integer, User> operations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(userId);
        if(hasKey){
            User user = operations.get(userId);
            log.info("从缓存区取出userId为{}的数据[{}]", userId, user.toString());
            return user;
        }
        User dbUser = userMapper.selectByPrimaryKey(userId);
        if(dbUser == null){
            throw new RuntimeException("userId无效");
        }
        operations.set(userId, dbUser, 3, TimeUnit.DAYS);
        log.info("新纪录插入userId为{}的数据[{}]到缓存:", userId, dbUser.toString());
        return dbUser;
    }
}