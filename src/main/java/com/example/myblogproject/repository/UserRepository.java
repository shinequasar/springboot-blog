package com.example.myblogproject.repository;

import com.example.myblogproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//DAO
//자동으로 bean 등록이됨
// @Repository 생략가능
public interface UserRepository extends JpaRepository<User, Long> {
    //JPA Naming 쿼리
    //SELECT * FROM user WHERE username =?1 AND password=?2;
    User findByUsernameAndPassword(String username, String password);

    //네이티브 쿼리방식(위와 같은 역할)
//    @Query(value="SELECT * FROM user WHERE username =?1 AND password=?2;")
//    User login(String username, String password);
}
