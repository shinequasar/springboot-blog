package com.example.myblogproject.test;

import com.example.myblogproject.model.RoleType;
import com.example.myblogproject.model.User;
import com.example.myblogproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DummyControllerTest {

    @Autowired //의존성 주입
    private UserRepository userRepository;

    @Transactional //함수 종료시 자동 commit -> save필요없음.
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User requestUser){ //Json데이터를 요청
        User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 정보수정에 실패하였습니다.")); //영속화됨
        user.setEmail(requestUser.getEmail());
        user.setPassword(requestUser.getPassword());
        //userRepository.save(user);
        return user;
    }

    @DeleteMapping("/dummy/user/{id}")
    public String deleteUser(@PathVariable Long id){
        try{
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){  //귀찮으면 모체인 Exception 걸어도 됨.
            return "삭제에 실패하였습니다. 해당 Id는 존재하지 않습니다.";
        }

        return "삭제되었습니다. Id : "+id;
    }

    @GetMapping("/dummy/users")
    public List<User> list(){
        return userRepository.findAll();
    }

    @GetMapping("/dummy/user") //http://localhost:8000/blog/dummy/user?page=1 이런식으로 페이지조회
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
        Page<User> pagingUser = userRepository.findAll(pageable);
        List<User> users = pagingUser.getContent();
        return users;
    }

    @GetMapping("/dummy/user/{id}") //만약 id 파라메터가 잘못되어 null이 반환되면 X.,Optional로 가져와 판단해 리턴하기
    public User detail(@PathVariable Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저는 존재하지 않습니다. Id : " +id));
        return user;
    }

    @PostMapping("/dummy/join")
    public String join(User user){ //key = value(약속된 규칙)
        System.out.println("username : "+user.getUsername());
        System.out.println("password : "+user.getPassword());
        System.out.println("email : "+user.getEmail());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}