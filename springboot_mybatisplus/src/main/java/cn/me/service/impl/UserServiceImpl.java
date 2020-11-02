package cn.me.service.impl;

import cn.me.domain.User;
import cn.me.mapper.UserMapper;
import cn.me.service.UserService;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//在类上指定用主库，但是有就近优先原则，在方法上指定的优先级更高
@DS("master")
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    @Override
    //指定数据源
    @DS("slave_1")
    public List<User> findAll()
    {
        return userMapper.selectList(null);
    }

    @Override
    @Transactional
    public void saveUser(User user)
    {
        userMapper.insert(user);
    }
}
