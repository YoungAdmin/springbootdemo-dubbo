package com.zhg.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zhg.common.responseResult.ResponseResult;
import com.zhg.dao.UserDao;
import com.zhg.pojo.User;
import com.zhg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ResponseResult findUserByName(String name) {
        try{
            User user = userDao.findByName(name).orElse(null);
            return ResponseResult.success(user);
        }catch (Exception e){
            return ResponseResult.failure(e.getMessage());
        }
    }
}
