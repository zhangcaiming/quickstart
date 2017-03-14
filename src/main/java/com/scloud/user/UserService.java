package com.scloud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> getUserList() {
        return userRepository.findAll(new PageRequest(0,10));
    }

    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Transactional
    public User update(User user) {
        // user对象的id在数据库中存在，就更新
        return userRepository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Transactional
    public User add(User user) {
        return userRepository.save(user);
    }

    // 批量新增
    @Transactional
    public void batchInsert(List<User> users) {
        userRepository.save(users);
    }

    // 批量更新
    @Transactional
    public void batchUpdate(List<User> users) {
        userRepository.save(users);
    }

    // 批量删除
    @Transactional
    public void batchDel(List<User> users) {
        userRepository.deleteInBatch(users);
    }

}
