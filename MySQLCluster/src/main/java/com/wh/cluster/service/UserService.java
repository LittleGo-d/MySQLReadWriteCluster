package com.wh.cluster.service;

import java.util.List;

import com.wh.cluster.annotation.ReadOnly;
import com.wh.cluster.entity.User;
import com.wh.cluster.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 测试读取，应该使用读库
     */
    @ReadOnly
    public List<User> getAll() {
        return userMapper.getAll();
    }

    /**
     * 测试读取和插入,应该使用写库
     */
    public void testReadAndWrite() {
        this.getAll();
        this.insertOne();
    }

    /**
     * 测试插入数据,应该使用写库
     */
    public void insertOne() {
        User user = new User();
        user.setName("测试");
        userMapper.insertOne(user);
    }

    /**
     * 测试事务能否正常工作
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void transInsert(){
        User user = new User();
        user.setName("heiheihei");
        userMapper.insertOne(user);
        throw new RuntimeException("测试事务");
    }
}
