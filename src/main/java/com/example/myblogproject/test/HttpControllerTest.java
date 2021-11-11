package com.example.myblogproject.test;

import org.springframework.web.bind.annotation.*;

// 사용자가 요청 -> 응답(HTML 파일)
// @Controller

// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

    //select
    @GetMapping("/http/get")
    public String getTest(){
        return "get 요청";
    }
    //instert
    @PostMapping("/http/post")
    public String pustTest(){
        return "pust 요청";
    }
    //update
    @PutMapping("/http/put")
    public String putTest(){
        return "put 요청";
    }
    //delete
    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete 요청";
    }
}