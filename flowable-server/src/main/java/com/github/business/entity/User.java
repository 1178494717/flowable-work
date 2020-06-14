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
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String userName;

    private String password;

    private String email;

    private String phoneNo;

    @OneToOne(cascade= CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "dept_id", referencedColumnName = "id", table = "ACT_DC_DEPT")
    private Dept dept;

    private Timestamp createTime;

    private Timestamp updateTime;
}
