package com.caozeal;

import com.caozeal.sometry.TryAboutFather;
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
    @RequestMapping("hello")
    public @ResponseBody String test() {
        return "hello, world! This com from spring!";
    }

    public static void main(String[] args) {
        int a = testX();
        System.out.println("0-" + a);
        TryAboutFather.test();
    }

    private static int testX() {
        int i = 1;
        try{
            System.out.println("1-" + i);
            System.out.println("x-" + i);
            throw new Exception();
//            return i;
        }catch (Exception e){
            ++i;
            return i;
        }
        finally {
            ++i;
            return i;
//            System.out.println("2-" + i);
        }
    }

}