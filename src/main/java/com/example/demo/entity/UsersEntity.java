package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity(name = "users") // 엔티티=JPA가 관리하는 클래스, 괄호안에꺼는 매핑할 테이블
@Data // getter+setter
public class UsersEntity {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동생성 = 기본키생성을 DB에 위임
    private Long id;

    @Column
    @Email(message = "잘못된 이메일 형식입니다.")
    @NotBlank(message = "이메일에 공백이 있습니다.")
    @NotNull(message = "이메일이 빈칸입니다.")
    private String email;

    @Column
    @Pattern(regexp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$", message = "잘못된 전화번호 형식입니다.")
    @NotBlank(message = "전화번호에 공백이 있습니다.")
    @NotNull(message = "전화번호가 빈칸입니다.")
    private String tel;

    @Column
    @Pattern(regexp = "^[가-힣]{2,10}$", message = "이름은 2~10글자의 한글로 입력해주세요.")
    @NotBlank(message = "이름에 공백이 있습니다.")
    @NotNull(message = "이름이 빈칸입니다.")
    private String name;

}
