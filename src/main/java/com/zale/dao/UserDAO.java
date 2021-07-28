package com.zale.dao;

import com.zale.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    User login(User user);
}