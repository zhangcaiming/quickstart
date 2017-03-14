package com.scloud.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> getUserList() {
        return userRepository.findAll(new PageRequest(0,10));
    }

    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    public User update(User user) {
        // user对象的id在数据库中存在，就更新
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

    public User add(User user) {
        return userRepository.save(user);
    }

}
