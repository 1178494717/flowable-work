package com.github.flowable.delegate;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * @date 2020/6/14
 */
@Component(value = "notifySuccessDelegate")
@Slf4j
public class NotifySuccessDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {

    }
}
