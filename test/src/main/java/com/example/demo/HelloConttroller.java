package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: jennie
 * Date: 2017/8/9
 * Time: 16:29
 */
@RequestMapping("/")
@Controller
public class HelloConttroller {

    @RequestMapping("/hello")
    public String HelloWorld(){
        return "hello";
    }
}
