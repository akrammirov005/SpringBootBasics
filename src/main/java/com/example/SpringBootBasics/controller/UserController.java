package com.example.SpringBootBasics.controller;

import com.example.SpringBootBasics.model.User;
import com.example.SpringBootBasics.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
//@RestController
@RequestMapping("/api")
public class UserController {

    //getting object of service
    @Autowired
    private UserService service;

    //Get all users
    @RequestMapping("/users")
    public List<User> findAllUsers(){
        return service.getAllUsers();
    }

    //Get single user
    @RequestMapping("/users/{id}")
    public User findUser(@PathVariable int id){
        return service.getUser(id);
    }

    //Create User
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        service.createUser(user);
        return service.getUser(user.getId());
    }

    //Update User
    @RequestMapping(path = "/users/{id}",method = RequestMethod.PUT)
    public User updateUser(@PathVariable int id, @RequestBody User user){
        service.updateUser(id,user);
        return service.getUser(id);
    }

    //Delete User
    @RequestMapping(path = "/users/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id){
        service.deleteUser(id);
    }

}
