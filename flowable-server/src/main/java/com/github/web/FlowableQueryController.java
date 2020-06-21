package com.github.web;

import com.github.service.ReimburseService;
import com.github.service.UserService;
import com.github.web.response.result.Response;
import com.github.web.response.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.HistoryService;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.impl.persistence.entity.ExecutionEntity;
import org.flowable.engine.impl.persistence.entity.HistoricProcessInstanceEntity;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.net.idn.Punycode;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @date 2020/6/20
 */
@RestController
@RequestMapping(value = "/flowable")
@Slf4j
public class FlowableQueryController {

    @Qualifier("processEngine")
    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private UserService userService;

    @Autowired
    private ReimburseService reimburseService;

    @GetMapping("/employee/applying")
    public ResponseResult<List<Object>> employeeApplying(String userId){
        RuntimeService runtimeService = processEngine.getRuntimeService();
        List<Object> collect = runtimeService.createProcessInstanceQuery().startedBy(userId).orderByStartTime().list()
                .stream().map(processInstance -> ((ExecutionEntity) processInstance).getPersistentState())
                .collect(Collectors.toList());
        return Response.makeOKRsp(collect);
    }

    @GetMapping("/employee/applied")
    public ResponseResult<List<Object>> employeeApplied(String userId){
        HistoryService historyService = processEngine.getHistoryService();
        List<Object> collect = historyService.createHistoricProcessInstanceQuery().startedBy(userId).finished().orderByProcessInstanceStartTime().list()
                .stream().map(historicProcessInstance -> ((HistoricProcessInstanceEntity) historicProcessInstance).getPersistentState())
                .collect(Collectors.toList());
        return Response.makeOKRsp(collect);
    }

    @GetMapping("/manager/applying")
    public ResponseResult<List<Object>> managerApplying(String userId){
        TaskService taskService = processEngine.getTaskService();
        List<Object> collect = taskService.createTaskQuery().taskCandidateOrAssigned(userId).list()
                .stream().map(task -> ((TaskEntity) task).getPersistentState())
                .collect(Collectors.toList());
        return Response.makeOKRsp(collect);
    }

    @GetMapping("/manager/applied")
    public ResponseResult<List<Object>> managerApplied(String userId){
        HistoryService historyService = processEngine.getHistoryService();
        List<Object> collect = historyService.createHistoricProcessInstanceQuery().involvedUser(userId).list()
                .stream().map(historicProcessInstance -> ((HistoricProcessInstanceEntity) historicProcessInstance).getPersistentState())
                .collect(Collectors.toList());
        return Response.makeOKRsp(collect);
    }
}
