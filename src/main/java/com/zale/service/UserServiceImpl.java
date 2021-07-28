package com.zale.service;

import com.zale.dao.UserDAO;
import com.zale.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {

        User userDB = userDAO.login(user);

        if(userDB!=null){
            return userDB;
        }
        throw  new RuntimeException("认证失败~~");
    }
}