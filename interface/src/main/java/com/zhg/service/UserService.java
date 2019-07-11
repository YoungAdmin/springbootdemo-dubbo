package com.zhg.service;

import com.zhg.common.responseResult.ResponseResult;

public interface UserService {

    /**
     * 通过用户姓名查找用户信息
     * @param name
     * @return
     */
    ResponseResult findUserByName(String name);
}
