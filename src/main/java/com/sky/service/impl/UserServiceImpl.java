package com.sky.service.impl;

import com.sky.mapper.UsersMapper;
import com.sky.pojo.Users;
import com.sky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
   @Autowired
    private UsersMapper usersMapper;

    @Override
    public void addUser(Users users) {
        this.usersMapper.insertUser(users);
    }

    @Override
    public List<Users> findUserAll() {

        return this.usersMapper.selectUsersAll();
    }

    @Override
    public Users selectUsersById(Integer id) {
        return this.usersMapper.selectUsersById(id);
    }

    @Override
    public void updateUser(Users users) {
        this.usersMapper.updateUser(users);
    }

    @Override
    public void deleteUserById(Integer id) {
        this.usersMapper.deleteUserById(id);
    }
}
