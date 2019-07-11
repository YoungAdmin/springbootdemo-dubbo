package com.zhg.dao;


import com.zhg.pojo.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDao extends CrudRepository<User,Long> {

    Optional<User> findByName(String name);

}
