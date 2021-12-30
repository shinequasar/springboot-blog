package com.example.myblogproject.repository;

import com.example.myblogproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//DAO
//자동으로 bean 등록이됨
// @Repository 생략가능
public interface UserRepository extends JpaRepository<User, Long> {
}
