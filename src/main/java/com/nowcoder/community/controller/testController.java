package com.nowcoder.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

//@Controller
public class testController {
    @RequestMapping(path="index",method = RequestMethod.GET)
    @ResponseBody
    public String getIndex(
            @RequestParam(name = "index_b",required = false,defaultValue = "2") int index,
            @RequestParam(name = "num_b",required = false,defaultValue = "43") int num
    ){

        return "index: "+index+" num: "+num ;
    }

    @RequestMapping("/index/{index_b}/{num_b}")
    @ResponseBody
    public String getIndexTwo(@PathVariable("index_b") int index,@PathVariable("num_b") int num){
        System.out.println("rest形式");
        return "index: "+index+" num: "+num ;
    }
    @RequestMapping("dealPost")
    @ResponseBody
    public String dealPost(String name,int age){
        return name+"  "+age;
    }
}
