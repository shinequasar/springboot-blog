package com.example.myblogproject.controller;

import com.example.myblogproject.config.auth.PrincipalDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/")  //홈 인덱스 매핑
    public String index(@AuthenticationPrincipal PrincipalDetail principal){ //컨트롤러에서 세션찾기
        //WEB-INF/views/index.jsp
        System.out.println("로그인 사용자아이디 : "+ principal.getUsername());
        return "index";
    }

}