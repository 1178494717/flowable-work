package com.github.business.entity;

import com.github.business.enums.DeptTypeEnum;
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
@Table(name = "ACT_DC_MANAGER")
@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userId;

    private String deptName;

    @Convert(converter = DeptTypeEnum.Converter.class)
    private String type;

}
