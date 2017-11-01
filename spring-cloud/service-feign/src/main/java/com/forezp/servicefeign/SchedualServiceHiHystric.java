package com.forezp.servicefeign;

import org.springframework.stereotype.Component;

/**
 * User: jennie
 * Date: 2017/10/24
 * Time: 14:41
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return  "sorry "+name;
    }
}
