package com.scloud.user;


import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 1. 继承UserSweeper,是为了能够在UserRepositoryImpl中使用EntityManager 对数据库操作
 *
 */
public interface UserRepository extends JpaRepository<User,Long>,UserSweeper{



}
