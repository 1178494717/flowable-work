package com.github.business.dto;

import com.github.business.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @date 2020/6/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReimburseDto {

    private Integer id;

    private String processIntanceId;

    private String userId;

    private BigDecimal amount;

    private String season;

    @Convert(converter = StatusEnum.Converter.class)
    private StatusEnum statusEnum;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
