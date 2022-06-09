package com.example.project.springboot.domain.posts;

import com.example.project.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter                 // 모든 필드의 Getter 메소드를 자동 생성
@NoArgsConstructor      // 기본 생성자 자동 추가
@Entity                 // 테이블과 링크될 클래스임을 나타냄 / 카멜케이스 이름을 언더스코어 네이밍으로 테이블명 매칭
public class Posts extends BaseTimeEntity {

    @Id                 // 해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙: GenerationType.IDENTITY 옵션을 추가해야 auto_increment가 됨
    private Long id;

    @Column(length = 500/* VARCHAR(500) */, nullable = false) // 테이블의 칼럼을 나타냄 / 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨 / 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)    //
    private String content;

    private String author;

    @Builder            // 빌더 패턴 클래스를 생성 / 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
