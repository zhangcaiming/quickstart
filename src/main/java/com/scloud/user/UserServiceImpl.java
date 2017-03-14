package com.scloud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Page<User> getUserList() {
        return userRepository.findAll(new PageRequest(0,10));
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User update(User user) {
        // user对象的id在数据库中存在，就更新
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    // 批量新增
    @Override
    public void batchInsert(List<User> users) {
        userRepository.save(users);
    }

    // 批量更新
    @Override
    public void batchUpdate(List<User> users) {
        userRepository.save(users);
    }

    // 批量删除
    @Override
    public void batchDel(List<User> users) {
        userRepository.deleteInBatch(users);
    }
}
