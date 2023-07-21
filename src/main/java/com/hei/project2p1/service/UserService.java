package com.hei.project2p1.service;

import com.hei.project2p1.model.UserEntity;
import com.hei.project2p1.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository repository;

    public boolean authenticated(String name, String password, HttpSession session){
        UserEntity user = repository.findByUserNameAndPassword(name,password) ;
        if(user!=null){
            session.setAttribute("user",user.getUserName());
            return true;
        }
        return false;
    }
}
