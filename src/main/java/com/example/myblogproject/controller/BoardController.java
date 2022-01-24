package com.example.myblogproject.controller;

import com.example.myblogproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String index(Model model,
                        @PageableDefault(size=3, sort = "id", direction= Sort.Direction.DESC)Pageable pageable){  // model은 jsp에서 request정보같은 거. model을 가지고 index까지 가져감
        model.addAttribute("boards", boardService.글목록(pageable));
        //WEB-INF/views/index.jsp
        return "index";  // viewResolver 작동
    }

    // user 권한이 필요
    @GetMapping("/board/saveForm")
    public String saveForm(){
        return "board/saveForm";
    }
}