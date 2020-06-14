package com.github.business.entity;

import com.github.business.enums.DeptTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @date 2020/6/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ACT_DC_DEPT")
public class Dept {

    @Id
    @GeneratedValue
    private Integer id;

    private String deptName;

    @Convert(converter = DeptTypeEnum.Converter.class)
    private String type;

    private Timestamp createTime;

    private Timestamp updateTime;

}
