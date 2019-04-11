package cn.silen_dev.sarcoidosis.service;

import cn.silen_dev.sarcoidosis.dao.UserDao;
import cn.silen_dev.sarcoidosis.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Resource
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userDao.getUserByUserName(s);
        if (null==user){
            throw new UsernameNotFoundException(s);
        }
        return user;
    }

    public User findUser(String s) {
        User user=userDao.getUserByUserName(s);
        return user;
    }

    public void register(String username,String password,String nickname){
        System.out.println(username);
        System.out.println(password);
        System.out.println(nickname);
        User user=new User();
        user.setNickname(nickname);
        user.setUsername(username);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setCreateTime(System.currentTimeMillis());
        userDao.insertUser(user);
    }
}
