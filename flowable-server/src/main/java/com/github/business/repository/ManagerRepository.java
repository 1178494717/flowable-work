package com.github.business.repository;

import com.github.business.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date 2020/6/15
 */
@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

    Manager findByUserId(String userId);

    List<Manager> findAllByDeptName(String deptName);

}
