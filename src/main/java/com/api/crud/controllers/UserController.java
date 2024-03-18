package com.api.crud.controllers;

import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService  userService;

    @GetMapping("/getAll")
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUser();
    }


    @PostMapping("/save")
    public UserModel saveUser(@RequestBody UserModel userModel){
        System.out.println("Se ha creado el usuario "+userModel.getFirstName());
        return this.userService.saveUser(userModel);
    }
    @GetMapping("/get/{id}")
    public Optional<UserModel> findById(@PathVariable Long id){
        return this.userService.findById(id);
    }

    @PutMapping("/update/{id}")
    public UserModel updateById(@PathVariable Long id , @RequestBody UserModel userModel){
        System.out.println("Se ha actualizado el usuario :) "+userModel.toString());
        return userService.updateUserById(userModel,id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        if(this.userService.deleteById(id)){
            return "Si se elimino "+id;
        }else{
            return  "ERROR ==>"+ id;
        }
    }


}
