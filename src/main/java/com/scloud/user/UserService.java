package com.scloud.user;


import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    Page<User> getUserList();

    User getUserById(Long id);

    User update(User user);

    void delete(Long id);

    User add(User user);

    void batchInsert(List<User> users);

    void batchUpdate(List<User> users);

    void batchDel(List<User> users);



}
