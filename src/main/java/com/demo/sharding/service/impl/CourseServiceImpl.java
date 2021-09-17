package com.demo.sharding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.common.utils.DateUtils;
import com.demo.domain.model.sharding.entity.Course;
import com.demo.sharding.dao.CourseMapper;
import com.demo.sharding.service.ICourseService;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
//    XA事物
//    @Transactional
//    @ShardingTransactionType(TransactionType.XA)  // 支持TransactionType.LOCAL, TransactionType.XA, TransactionType.BASE
//    seata事物
    @Transactional
    @ShardingTransactionType(TransactionType.BASE)  // 支持TransactionType.LOCAL, TransactionType.XA, TransactionType.BASE
    public void purchase() {
        //在调用db时设置，可以对事务类型进行切换
        //其他服务中也需要配置
        TransactionTypeHolder.set(TransactionType.BASE);
        int year = 2019;
        for(int i=1;i<=10;i++) {
            if(i == 5){
                int a = 1/0;
            }
            Course course = new Course();
            course.setCname("java"+i);
            course.setUserId("1");
            course.setCstatus("Normal"+i);
            String dateStr = year + i + "-12-31";
            course.setYear(DateUtils.stringToDate(dateStr));
            courseMapper.insert(course);
        }
    }
}
