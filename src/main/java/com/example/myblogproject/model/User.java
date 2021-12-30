package com.example.myblogproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;


//@DynamicInsert -> inster 시에 null인 필드를 제외시켜준다.
@NoArgsConstructor
@AllArgsConstructor
@Builder @Data
@Entity // User 클래스가 MySql에 테이블이 생성된다.
public class User {
    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라감
    private Long id; //시퀀스, auto_increment

    @Column(nullable = false, length = 30)
    private String username; //아이디

    @Column(nullable = false, length = 100)//hash로 암호화 할거라 넉넉히 줌
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    //@ColumnDefault("'user'")  //디폴트값 설정
    //DB는 RoleType 이라는게 없다. -> enum의 타입은 string이라는거 알러주기.
    @Enumerated(EnumType.STRING)
    private RoleType role; //Enum을 쓰는게 좋다. admin, user, manager

    @CreationTimestamp // 시간이 자동입력
    private Timestamp createDate;
}