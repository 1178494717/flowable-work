package com.github.business.repository;

import com.github.business.entity.Manager;
import com.github.business.entity.ReimburseForm;
import com.github.business.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date 2020/6/15
 */
@Repository
public interface ReimburseRepository extends JpaRepository<ReimburseForm, Integer> {

    ReimburseForm findById(String id);

    List<ReimburseForm> findByUserIdAndStatusEnum(String userId, StatusEnum statusEnum);

}
