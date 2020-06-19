package com.github.business.dto;

import com.github.business.entity.Manager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @date 2020/6/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;

    private String userId;

    private String userName;

    private String password;

    private String email;

    private Manager manager;
}
