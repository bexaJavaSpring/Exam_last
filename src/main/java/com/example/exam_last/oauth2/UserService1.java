package com.example.exam_last.oauth2;

import com.example.exam_last.entity.User;
import com.example.exam_last.entity.enums.Provider;
import com.example.exam_last.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService1 {

    @Autowired
    private UserRepository repo;

    public void processOAuthPostLogin(String username) {
        User existUser = repo.getByUserName(username);

        if (existUser == null) {
            User newUser = new User();
            newUser.setUserName(username);
            newUser.setProvider(Provider.FACEBOOK);
            newUser.setActive(true);
            repo.save(newUser);
        }
    }
}
