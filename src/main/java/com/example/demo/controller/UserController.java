package com.example.demo.controller;


import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user/{username}/{password}")
    public void addUser(@PathVariable String username, @PathVariable String password){

        User user = new User(username,password);
        userRepository.save(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
      List<User> sortedUsers = userRepository.findAll().stream()
              .sorted(Comparator.comparing(User::getScore).reversed())
              .collect(Collectors.toList());
      return sortedUsers;



    }

    @GetMapping("/user")
    public User getWelcome(){
        return  userRepository.findAll().get(0);
    }
    @GetMapping("/user/{username}/{password}")
    public User login(@PathVariable String username, @PathVariable String password){
        Long id;
        User user = userRepository.findOneByUsernameAndPassword(username,password);
        if(user!=null){
            id = user.getId();
        }else{
            id = 100000L;
        }
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

    }
    @GetMapping("/user/{username}")
    public User getUserByName(@PathVariable String username){
        return userRepository.findOneByUsername(username);
    }

    @GetMapping("/user/{username}/change/{score}")
    public void changeScore(@PathVariable String username , @PathVariable Integer score){
       User user =  userRepository.findOneByUsername(username);
       user.setScore(user.getScore()+score);
       userRepository.save(user);
    }

    @GetMapping("/user/{username}/decreaseHP")
    public void decreaseHP(@PathVariable String username){
        User user =  userRepository.findOneByUsername(username);
        user.setHp(user.getHp()-1);
        userRepository.save(user);
    }





}
