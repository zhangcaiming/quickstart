package com.scloud.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

<<<<<<< HEAD
import java.util.List;

public interface UserService {
=======
public class UserService {
>>>>>>> efa12daa280c6f0fa6c79ef764ded70f64ca22d3

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

<<<<<<< HEAD
    void batchInsert(List<User> users);

    void batchUpdate(List<User> users);

    void batchDel(List<User> users);

=======
    public void delete(Long id) {
        userRepository.delete(id);
    }
>>>>>>> efa12daa280c6f0fa6c79ef764ded70f64ca22d3

    public User add(User user) {
        return userRepository.save(user);
    }

}
