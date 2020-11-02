package cn.me.service;

import cn.me.domain.User;

import java.util.List;

public interface UserService
{
    //保存走master库，查询走slave库
    List<User> findAll();

    void saveUser(User user);
}
