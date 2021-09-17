package com.demo.sharding.config.strategy;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * 按年自定义分片逻辑
 */
public class YearShardingAlgorithm implements PreciseShardingAlgorithm<Date> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Date> preciseShardingValue) {

        //preciseShardingValue就是当前插入的字段值
        //collection 内就是所有的逻辑表
        //获取字段值
        Date time = preciseShardingValue.getValue();

        if(time == null){
            throw new UnsupportedOperationException("分片异常： prec is null");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String year =sdf.format(time);
////      根据奇偶年份入表
//        for(String tableName : collection){
//            String[] tableNames = tableName.split("_");
//            String tableStr = tableNames[tableNames.length - 1];
//            if(Integer.parseInt(year) % 2 + 1 == Integer.parseInt(tableStr)){
//                return tableName;///返回要插入的逻辑表
//            }
//        }

//        已知固定表名前缀，根据年份入库
        for (String tableName : collection) {//循环表名已确定使用哪个库
            String name = tableName.substring(tableName.length() - 1);
            if(Integer.parseInt(year) % 2 + 1 == Integer.parseInt(name)){
                return tableName;//返回要插入的逻辑表
            }
        }
        return null;
    }
}
