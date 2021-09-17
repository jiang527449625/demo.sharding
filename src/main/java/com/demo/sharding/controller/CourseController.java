package com.demo.sharding.controller;

import com.demo.common.mybatis.Result;
import com.demo.common.mybatis.ResultGenerator;
import com.demo.domain.model.sys.vo.SysLogVO;
import com.demo.sharding.service.ICourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* Created by jky on 2021/04/28.
*/

@Api(tags={"分库测试"})
@RestController
@RequestMapping("/sharding/noAuth/course")
public class CourseController {
    @Resource
    private ICourseService courseService;

    @ApiOperation(value = "分库新增测试", notes = "/sharding/course/insert")
    @PostMapping("/insert")
    @ResponseBody
    public Result add() {
        courseService.purchase();
        return ResultGenerator.genSuccessResult();
    }
}
