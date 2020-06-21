package com.github.web;

import com.github.business.dto.ReimburseDto;
import com.github.business.dto.UserDto;
import com.github.business.entity.Manager;
import com.github.business.enums.DeptTypeEnum;
import com.github.service.ReimburseService;
import com.github.service.UserService;
import com.github.web.response.result.Response;
import com.github.web.response.result.ResponseResult;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2020/6/20
 */
@RestController
@RequestMapping(value = "/flowable")
public class FlowableOptController {

    @Qualifier("processEngine")
    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private UserService userService;

    @Autowired
    private ReimburseService reimburseService;

    @PostMapping("/start")
    public ResponseResult<String> startProcessInstance(@RequestBody ReimburseDto reimburseDto){
        RuntimeService runtimeService = processEngine.getRuntimeService();
        String userId = reimburseDto.getUserId();
        UserDto userDto = userService.getUserDto(userId);
        List<Manager> managerList = userService.findAllByDeptName(userDto.getDeptName());
        Manager sectionManager = managerList.stream().filter(manager -> manager.getDeptType().equals(DeptTypeEnum.SECTION_HEAD.getDeptType())).findFirst().get();

        Map<String, Object> variables = new HashMap<>();
        variables.put("businessKey", reimburseDto.getId());
        variables.put("amount", reimburseDto.getAmount().doubleValue());
        variables.put("limit", sectionManager.getManagerLimit().doubleValue());
        variables.put("approved", true);

        ProcessInstance processInstance = runtimeService.createProcessInstanceBuilder()
                .processDefinitionId("")
                .variables(variables)
                .name("Reimburse Form")
                .businessKey(String.valueOf(reimburseDto.getId()))
                .startAsync();

        reimburseDto.setProcessIntanceId(processInstance.getId());
        reimburseService.save(reimburseDto);
        return Response.makeOKRsp(processInstance.getProcessInstanceId());
    }
}
