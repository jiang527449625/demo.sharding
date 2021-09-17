package com.demo.sharding.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.demo.domain.model.sharding.entity.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: 用户管理
 * @Author: jky
 * @Date: 2021/8/16 15:17
 */
@Component
public interface CourseMapper extends BaseMapper<Course> {

    List<Course> selectSqlList(Course course);

    IPage<Course> selectPageSqlCourse(IPage<Course> page, @Param(Constants.WRAPPER) Wrapper<Course> queryWrapper);
}