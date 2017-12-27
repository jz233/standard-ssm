package cn.zjj.service.impl;

import cn.zjj.dao.UserMapper;
import cn.zjj.entity.User;
import cn.zjj.service.BaseService;
import cn.zjj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public User getUser() {
        return userMapper.getUser();
    }

    @Override
    public String getPasswordByUsername(String username) {
        return userMapper.getPasswordByUsername(username);
    }

}
