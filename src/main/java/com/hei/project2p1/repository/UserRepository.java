package com.hei.project2p1.repository;

import com.hei.project2p1.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUserNameAndPassword(String userName, String password);
}
