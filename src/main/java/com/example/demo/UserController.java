package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
        private UserRepository userRepository;
@RequestMapping("queryUser")
    public List<User> testUser(){

        return userRepository.findAll();
    }
    @PostMapping("addUser")
    public User addUser(@RequestParam("user_name") String user_name,@RequestParam("user_pass") String user_pass){
       User user = new User();
        user.setUserName(user_name);
        user.setUserPass(user_pass);
        return  userRepository.save(user);
    }

    @DeleteMapping("deleteUser/{user_id}")
    public void deleteUser(@PathVariable("user_id") Integer user_id){
    userRepository.delete(user_id);

 }

}
