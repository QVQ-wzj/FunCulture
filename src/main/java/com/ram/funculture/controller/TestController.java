package com.ram.funculture.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hu
 * @version 1.0
 * @description: TODO
 * @date 2021/10/26
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "你好";
    }
}
