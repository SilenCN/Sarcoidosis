package cn.silen_dev.sarcoidosis.dao;

import cn.silen_dev.sarcoidosis.model.User;

public interface UserDao {
    User getUserByUserName(String name);
    void insertUser(User user);
}
