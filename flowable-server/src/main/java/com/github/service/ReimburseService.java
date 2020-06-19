package com.github.service;

import com.github.business.dto.ReimburseDto;
import com.github.business.entity.ReimburseForm;
import com.github.business.repository.ReimburseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @date 2020/6/16
 */
@Service
@Slf4j
public class ReimburseService {

    @Autowired
    private AppStore appStore;

    @Autowired
    private ReimburseRepository reimburseRepository;

    public ReimburseForm save(ReimburseDto reimburseDto) {
        ReimburseForm reimburseForm = new ReimburseForm();
        BeanUtils.copyProperties(reimburseDto, reimburseForm);
        reimburseForm.setUpdateTime(LocalDateTime.now());
        if(reimburseDto.getId() == null || reimburseDto.getId() == 0){
            reimburseForm.setCreateTime(LocalDateTime.now());
        }
        return reimburseRepository.save(reimburseForm);
    }
}
