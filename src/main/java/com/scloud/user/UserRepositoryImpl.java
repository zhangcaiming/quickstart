package com.scloud.user;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository("userRepositoryImpl")
public class UserRepositoryImpl implements UserSweeper {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User getByNickName(String nickName) {
        String sql = "SELECT * FROM User WHERE nickName=?";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1,nickName);
        return (User) query.getSingleResult();
    }
}
