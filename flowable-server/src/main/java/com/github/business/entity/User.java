package com.github.business.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @date 2020/6/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ACT_DC_USER")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userId;

    private String userName;

    private String password;

    private String email;

    private String deptName;

}
