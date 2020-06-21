package com.github.business.entity;

import com.github.business.enums.StatusEnum;
import com.github.business.util.LocalDateTimeConvert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @date 2020/6/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ACT_DC_REIMBURSE")
@Entity
public class ReimburseForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String processIntanceId;

    private String userId;

    private BigDecimal amount;

    private String season;

    @Convert(converter = StatusEnum.Converter.class)
    private StatusEnum statusEnum;

    @Convert(converter = LocalDateTimeConvert.class)
    private LocalDateTime createTime;

    @Convert(converter = LocalDateTimeConvert.class)
    private LocalDateTime updateTime;

}
