package com.wh.cluster.mapper;

import com.wh.cluster.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 获取全部数据
     * @return List<Test>
     */
    List<User> getAll();

    /**
     * 插入一条数据
     * @param user 数据
     */
    void insertOne(@Param("user") User user);
}
