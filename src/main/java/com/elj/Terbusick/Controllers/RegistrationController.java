package com.elj.Terbusick.Controllers;

import com.elj.Terbusick.domain.User;
import com.elj.Terbusick.domain.enums.Role;
import com.elj.Terbusick.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User  userFromDb = userRepository.findByUsername(user.getUsername());
        if(userFromDb != null){
        model.put("message", "User exist");
        return "registration";
        }
        user.setActive(true);
        user.setRoles((Collections.singleton(Role.ROLE_ADMIN)));
        userRepository.save(user);
        return"redirect:/login";
    }
}

