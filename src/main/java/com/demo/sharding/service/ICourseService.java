package com.demo.sharding.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.domain.model.sharding.entity.Course;

public interface ICourseService extends IService<Course> {
    void purchase();
}
