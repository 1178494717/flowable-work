package com.github.web;

import com.github.business.dto.ReimburseDto;
import com.github.business.entity.ReimburseForm;
import com.github.service.ReimburseService;
import com.github.web.response.result.Response;
import com.github.web.response.result.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @date 2020/6/19
 */
@RestController
@RequestMapping("/reimburse")
public class ReimburseController {

    @Autowired
    private ReimburseService reimburseService;


    @PostMapping
    public ResponseResult<ReimburseForm> save(@RequestBody ReimburseDto reimburseDto){
        ReimburseForm reimburseForm = reimburseService.save(reimburseDto);
        return Response.makeOKRsp(reimburseForm);
    }

}
