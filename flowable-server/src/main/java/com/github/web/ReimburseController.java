package com.github.web;

import com.github.business.dto.ReimburseDto;
import com.github.business.entity.ReimburseForm;
import com.github.service.ReimburseService;
import com.github.web.response.result.Response;
import com.github.web.response.result.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.net.idn.Punycode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @date 2020/6/19
 */
@RestController
@RequestMapping("/reimburse")
public class ReimburseController {

    @Autowired
    private ReimburseService reimburseService;


    @PostMapping("/save")
    public ResponseResult<ReimburseDto> save(@RequestBody ReimburseDto reimburseDto){
        ReimburseForm reimburseForm = reimburseService.save(reimburseDto);
        BeanUtils.copyProperties(reimburseForm, reimburseDto);
        return Response.makeOKRsp(reimburseDto);
    }

    @GetMapping(name = "list")
    public ResponseResult<List<ReimburseDto>> list(String userId){
        List<ReimburseDto> list = reimburseService.findAllByUserId(userId);
        return Response.makeOKRsp(list);
    }

    @PostMapping("/create")
    public ResponseResult<ReimburseDto> create(){
        ReimburseDto reimburseDto = new ReimburseDto();
        reimburseDto.setCreateTime(LocalDateTime.now());
        reimburseDto.setUpdateTime(LocalDateTime.now());
        ReimburseForm reimburseForm = reimburseService.save(reimburseDto);
        BeanUtils.copyProperties(reimburseForm, reimburseDto);
        return Response.makeOKRsp(reimburseDto);
    }
}
