package com.demo.sharding.config.strategy;

import com.demo.common.utils.SnowflakeIdUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * 自定义主键策略生成
 */
@Component
@Slf4j
public class KeyGenerator implements ShardingKeyGenerator {
    @Getter
    @Setter
    private Properties properties;

    @Override
    public Comparable<?> generateKey() {
        return  SnowflakeIdUtil.newStringId();
    }

    //设置在yaml内的名字
    @Override
    public String getType() {
        return "auto_snowflakeId";
    }
}
