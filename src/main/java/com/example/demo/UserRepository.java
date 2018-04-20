package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Modifying
    @Transactional
    @Query("delete from User u where u.userId =?1")
    void delete(Integer user_id);
}
