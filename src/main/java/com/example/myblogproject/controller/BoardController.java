package com.example.myblogproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/")  //홈 인덱스 매핑
    public String index(){
        //WEB-INF/views/index.jsp
        return "index";
    }

}