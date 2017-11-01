package com.forezp.servicefeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * User: jennie
 * Date: 2017/10/24
 * Time: 10:10
 */
@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name")  String name);
}
