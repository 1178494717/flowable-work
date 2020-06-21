package com.github.service;

import com.github.business.dto.ReimburseDto;
import com.github.business.entity.ReimburseForm;
import com.github.business.enums.StatusEnum;
import com.github.business.repository.ReimburseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public ReimburseDto reimburseDto(Integer id){
        return (ReimburseDto)appStore.computeIfAbsent(id, o -> reimburseRepository.getOne(id));
    }

    public ReimburseForm save(ReimburseDto reimburseDto) {
        ReimburseForm reimburseForm = new ReimburseForm();
        BeanUtils.copyProperties(reimburseDto, reimburseForm);
        reimburseForm.setUpdateTime(LocalDateTime.now());
        if(reimburseDto.getId() == null || reimburseDto.getId() == 0){
            reimburseForm.setCreateTime(LocalDateTime.now());
        }
        return reimburseRepository.save(reimburseForm);
    }

    public List<ReimburseDto> findAllByUserId(String userId) {
        return reimburseRepository.findByUserIdAndStatusEnum(userId, StatusEnum.DRAFT).stream().map(reimburseForm -> {
            ReimburseDto reimburseDto = new ReimburseDto();
            BeanUtils.copyProperties(reimburseForm, reimburseDto);
            return reimburseDto;
        }).collect(Collectors.toList());
    }
}
