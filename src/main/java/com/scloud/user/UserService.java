package com.scloud.user;


import org.springframework.data.domain.Page;

public interface UserService {

    Page<User> getUserList();

    User getUserById(Long id);

    User update(User user);

    void delete(Long id);

    User add(User user);



}
