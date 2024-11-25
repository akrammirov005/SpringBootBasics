package com.example.SpringBootBasics.service;

import com.example.SpringBootBasics.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    List<User> users = new ArrayList<>(Arrays.asList(
            new User(1,"Mirov Akram","Dushanbe"),
            new User(2,"Neiton John","London"),
            new User(3,"Anna Johnson","Moscow"),
            new User(4,"Sam Salimon","Washington")
            ));

    //creating business logic for UserController
    public List<User> getAllUsers(){
        return users;
    }

    public User getUser(int id){
        //#1
        return users.stream().filter(n -> n.getId() == id).findFirst().get();

        //#2
        //User userSingle = null;
        //for (User user: users){
            //if (user.getId() == id)
                //userSingle = user;
        //}
        //return userSingle;
    }

    //Create User Logic
    public void createUser(User user){
        users.add(user);
    }

    //Update User
    public void updateUser(int id,User user) {
        for (User userClient : users) {
            if (userClient.getId() == id) {
                userClient.setName(user.getName());
                userClient.setCity(user.getCity());
            }
        }
    }

    //Delete User
    public void deleteUser(int id){
       List<User> users1 =  new ArrayList<>();
       for (User user: users){
           if (user.getId() == id){
               continue;
           }
           users1.add(user);
       }
       this.users = users1;
    }

}
