package com.demo.sharding;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.common.utils.DateUtils;
import com.demo.domain.model.sharding.entity.Course;
import com.demo.sharding.dao.CourseMapper;
import com.demo.sharding.service.ICourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingTest {

    //注入mapper
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private ICourseService iCourseService;

    public static void main(String[] args) {
        System.out.println(192168118%32+"===========");
    }

    @Test
    public void addCourse() {
        iCourseService.purchase();
    }

    @Test
    public void updateCourse() {
        Course course = new Course();
        course.setCid("353119409597276161");//course_2
        course.setCname("jky-1");
        courseMapper.updateById(course);
        course.setCid("353119424889708545");//course_1
        course.setCname("jky-1");
        courseMapper.updateById(course);
    }

    @Test
    public void delCourse() {
        Course course = new Course();
        course.setCid("353119409597276161");//course_2
        course.setCname("jky-1");
        courseMapper.delete(Wrappers.<Course>lambdaUpdate(course));
    }

    @Test
    public void selectCourse() {
        Course course = new Course();
        String str = "2021-12-31";
        course.setYear(DateUtils.stringToDate(str));
        courseMapper.selectList(Wrappers.<Course>lambdaQuery(course));
    }

    @Test
    public void selectPageCourse() {
        Course course = new Course();
        IPage<Course> page = new Page<>(1,10);
        IPage<Course> list = courseMapper.selectPage(page,Wrappers.<Course>lambdaQuery().orderByAsc(Course::getYear));
    }

    @Test
    public void selectSqlCourse() {
        Course course = new Course();
        String str = "2021-12-31";
        course.setYear(DateUtils.stringToDate(str));
        List<Course> list = courseMapper.selectSqlList(course);
    }

    @Test
    public void selectPageSqlCourse() {
        IPage<Course> page = new Page<>(1,10);
        IPage<Course> list = courseMapper.selectPageSqlCourse(page,Wrappers.<Course>lambdaQuery().ge(Course::getCid,"89999995"));
    }
//    public static void main(String[] args) {
//        String jdbc_diver_class = "oracle.jdbc.driver.OracleDriver";
//        String jdbc_url = "jdbc:oracle:thin:@192.168.1.30:1521:slyyhis";
//        String jdbc_username = "shyt";
//        String jdbc_password = "shyt010203";
//        String base_package = "com.demo.sys";//项目基础包名称，根据自己公司的项目修改
//        String model = "sys";//模块
//        String project_path = System.getProperty("user.dir");//项目在硬盘上的基础路径
////        project_path = "D:/workSpace1/demo.sys";
//        CodeGenerator generator = new CodeGenerator(base_package, project_path, jdbc_diver_class, jdbc_url, jdbc_username, jdbc_password, model);
//        String[] tables = {"customer_form_relation"};
//        Arrays.stream(tables).forEach(table -> {
////          这里生成表对应的文件名所以第一个字母大写
//            String modelName = CodeGenerator.tableNameConvertLowerCamel(table,true);
//            generator.generatorCode(table, modelName);
//        });
//
//    }

}
