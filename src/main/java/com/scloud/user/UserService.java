package com.scloud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSweeper userSweeper;

    public Page<User> getUserList() {
        return userRepository.findAll(new PageRequest(0,10));
    }

    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

    public User add(User user) {
        return userRepository.save(user);
    }

    public void batchInsert(List<User> users) {
        userRepository.save(users);
    }

    public void batchUpdate(List<User> users) {
        userRepository.save(users);
    }

    public void batchDelete(List<User> users) {
        userRepository.deleteInBatch(users);
    }

    public User getUserByNick(String name) {
        return userSweeper.getByNickName(name);
    }

}
