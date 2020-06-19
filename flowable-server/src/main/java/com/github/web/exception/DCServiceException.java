package com.github.web.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.flowable.engine.RuntimeService;

/**
 * @date 2020/6/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DCServiceException extends RuntimeException {
    private Integer code;
    private String msg;
    private String message;

}
