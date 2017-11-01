package com.forezp.serviceribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: jennie
 * Date: 2017/10/23
 * Time: 18:03
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;


    @RequestMapping(value = "hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }
}
