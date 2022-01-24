package com.example.myblogproject.service;

import com.example.myblogproject.dto.ResponseDto;
import com.example.myblogproject.model.Board;
import com.example.myblogproject.model.RoleType;
import com.example.myblogproject.model.User;
import com.example.myblogproject.repository.BoardRepository;
import com.example.myblogproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//스프링이 컴포넌트 스캔을 통해 Bean에 등록을 해줌. IOC를 해준다.
@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void 글쓰기(Board board, User user){ //title, content
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Page<Board> 글목록(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Board 글상세보기(Long id) throws IllegalAccessException {
        return boardRepository.findById(id)
                .orElseThrow(()->{
            return new IllegalAccessException("글 상세보기 실패 : 아이디를 찾을 수 없습니다.");
        });
    }

    @Transactional
    public void 삭제하기(Long id) {
        boardRepository.deleteById(id);
    }
}