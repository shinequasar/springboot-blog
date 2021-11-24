package com.example.myblogproject.test;

import org.springframework.web.bind.annotation.*;

// 사용자가 요청 -> 응답(HTML 파일)
// @Controller

// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest : ";

    @GetMapping("/http/lombok")
    public String lombokTest(){
        Member m = new Member.MemberBuilder().username("want").password("1234").email("email").build();
        System.out.println(TAG+"getter : "+m.getUsername());
        m.setUsername("want");
        System.out.println(TAG+"setter : "+m.getUsername());
        return "lombok test 완료";
    }

    //select
    @GetMapping("/http/get")
    public String getTest(Member m){
        return "get 요청 : "+m.getId()+" , "+m.getUsername()+" , "+m.getPassword();
    }
    //instert
    @PostMapping("/http/post")
    public String pustTest(@RequestBody Member m){  //MessageConverter(스프링부트)
        return "post 요청 : "+ m.getId()+" , "+m.getUsername()+" , "+m.getPassword();
    }
    //update
    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m){
        return "put 요청 : "+ m.getId()+" , "+m.getUsername()+" , "+m.getPassword();
    }
    //delete
    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete 요청";
    }
}