package cn.zjj.dao;

import cn.zjj.entity.User;

public interface UserMapper {

    User getUser();

    String getPasswordByUsername(String username);
}
