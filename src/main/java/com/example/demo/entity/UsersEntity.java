package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "users") // 엔티티=JPA가 관리하는 클래스, 괄호안에꺼는 매핑할 테이블
@Data // getter+setter
public class UsersEntity {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동생성 = 기본키생성을 DB에 위임
    private Long id;

    private String email;

    private String tel;

    private String name;

}
