package com.example.myblogproject.repository;

import com.example.myblogproject.model.Board;
import com.example.myblogproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//DAO
//자동으로 bean 등록이됨
// @Repository 생략가능
public interface BoardRepository extends JpaRepository<Board, Long> {

}