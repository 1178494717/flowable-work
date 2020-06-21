package com.github.service;

import com.github.business.dto.UserDto;
import com.github.business.entity.Manager;
import com.github.business.entity.User;
import com.github.business.repository.ManagerRepository;
import com.github.business.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @date 2020/6/16
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private AppStore appStore;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ManagerRepository managerRepository;

    public UserDto getUserDto(String userId){
        return (UserDto) appStore.computeIfAbsent(userId, o -> {
            User user = userRepository.findByUserId(userId);
            if(user == null){
                return  null;
            }
            Manager manager = managerRepository.findByUserId(userId);
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            userDto.setManager(manager);
            return userDto;
        });
    }

    public List<Manager> findAllByDeptName(String deptName){
        return (List<Manager>) appStore.computeIfAbsent(deptName, o -> managerRepository.findAllByDeptName(deptName));
    }
}
