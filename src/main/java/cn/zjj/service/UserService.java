package cn.zjj.service;

import cn.zjj.entity.User;

public interface UserService {

    User getUser();

    String getPasswordByUsername(String username);

}
