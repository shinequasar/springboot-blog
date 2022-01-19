package com.example.myblogproject.controller.api;

import com.example.myblogproject.dto.ResponseDto;
import com.example.myblogproject.model.RoleType;
import com.example.myblogproject.model.User;
import com.example.myblogproject.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {
    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @ApiOperation(value = "회원가입 메소드", notes = "회원가입을 하는 메소드입니다.")
    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("UserApiController : save 호출됨");
        user.setRole(RoleType.USER);
        userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @ApiOperation(value = "로그인 메소드", notes = "로그인을 하는 메소드입니다.")
    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user){
        System.out.println("UserApiController : login 호출됨");
        User principal = userService.로그인(user); //principal (접근주체)

        if(principal != null){
            session.setAttribute("principal",principal); //key, value
        }else System.out.println("세션 비어있음");

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}