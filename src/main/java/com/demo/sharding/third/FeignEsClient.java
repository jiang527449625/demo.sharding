package com.demo.sharding.third;

import com.alibaba.fastjson.JSONArray;
import com.demo.common.mybatis.Result;
import com.demo.sharding.third.impl.HystrixFeignEsClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author jky
 * @Time 2021年4月21日09:52:09
 * @Description
 */

@FeignClient(value = "${cloud.service.name}",
        fallback = HystrixFeignEsClient.class)
public interface FeignEsClient {
}

