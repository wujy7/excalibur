package com.jd.excalibur.controller.index;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class IndexController {

    @GetMapping("/")
    @ResponseBody
    public Object initArthur(){
        return "亚瑟";
    }

}
