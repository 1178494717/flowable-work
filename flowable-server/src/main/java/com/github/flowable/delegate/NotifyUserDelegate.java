package com.github.flowable.delegate;

import lombok.extern.slf4j.Slf4j;
import org.flowable.common.engine.api.delegate.Expression;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.engine.impl.persistence.entity.ExecutionEntity;
import org.springframework.stereotype.Component;

/**
 * @date 2020/6/14
 */
@Component(value = "notifyUserDelegate")
@Slf4j
public class NotifyUserDelegate implements JavaDelegate {

    private Expression type;

    @Override
    public void execute(DelegateExecution execution) {
        ExecutionEntity executionEntity = (ExecutionEntity) execution;
    }
}
