package com.example.myblogproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 대용량데이터
    private String content; //섬머노트 라이브러리 <html>태그가 섞여서 디자인이 됨.

    private int count; //조회수

    @ManyToOne(fetch = FetchType.EAGER) // Many = Board, User = one
    @JoinColumn(name="userId")
    private User user; //DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // mappedBy 연관관계의 주인이 X. (난 FK가 X) DB에 컬럼을 만들지마.
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;
}