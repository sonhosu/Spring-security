package com.cos.security1.repository;

import com.cos.security1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


//CRUD 함수를 JpaRepository 가 들고있다.
// @Repository 라는 어노테이션이 없어도 IoC 됨. 이유는 JpaRepository를 상속했기때문
public interface UserRepository extends JpaRepository<User, Integer> {
    //findBy 규칙 -> Username 문법
    // select * from user where username = username(파라미터)
    public User findByUsername(String username);

}
