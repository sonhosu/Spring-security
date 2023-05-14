package com.cos.security1.controller;


import com.cos.security1.model.User;
import com.cos.security1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @GetMapping({"","/"})
    public String index(){

        //머스테치 기본폴더 src/main/resources/
        return "index";
    }

    @GetMapping("/user")
    public @ResponseBody String user(){
        return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin(){
        return "admin";
    }

    @GetMapping("/manager")
    @ResponseBody
    public  String manager(){
        return "manager";
    }

    @GetMapping("/loginForm")
    public  String login(){
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public  String joinForm(){
        return "joinForm";
    }

    @PostMapping("/join")
    public  String join(User user){
        System.out.println("user:"+user);
        user.setRole("ROLE_USER");
        String rawPassword = user.getPassword();
        String encpassword = bCryptPasswordEncoder.encode(rawPassword);// 패스워드 암호화
        user.setPassword(encpassword);
        userRepository.save(user);
        return "redirect:/loginForm";
    }


}
