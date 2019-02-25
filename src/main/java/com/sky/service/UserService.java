package com.sky.service;

import com.sky.pojo.Users;

import java.util.List;

public interface UserService {
    void  addUser(Users users);
    List<Users> findUserAll();
    Users selectUsersById(Integer id);
    void  updateUser(Users users);
    void  deleteUserById(Integer id);
}
