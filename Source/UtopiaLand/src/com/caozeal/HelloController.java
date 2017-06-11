package com.caozeal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    
    /**
     * 欢迎
     * <p>
     * 创建时间：2017年6月10日下午10:36:01
     * @author caozeal
     * @return
     */
    @RequestMapping("/hello")
    public @ResponseBody String test() {
        return "hello, world! This com from spring!";
    }

}