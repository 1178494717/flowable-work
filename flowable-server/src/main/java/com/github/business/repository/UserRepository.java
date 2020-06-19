package com.github.business.repository;

import com.github.business.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @date 2020/6/15
 */
@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {

    User findByUserId(String userId);

}
