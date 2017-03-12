package com.scloud.user;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface UserRepository extends JpaRepository<User,Long>,UserSweeper{

    Page<User> findByAddressOrderByUserNameDesc(String address, Pageable pageable);

    User findByEmail(String email);

    @Query("select u From User u where u.userName=?1")
    User getUserByName(String name);

    @Transactional
    @Modifying
    @Query("update User u set u.userName=?1 Where u.id=?2 ")
    User updateUserName(String name,Long id);


    @Transactional
    @Modifying
    @Query("delete from User WHERE id=:id")
    void deleteUserById(@Param("id") Long id);





}
