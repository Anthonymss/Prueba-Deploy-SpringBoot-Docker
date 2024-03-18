package com.api.crud.services;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUser(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel userModel){
        return  userRepository.save(userModel);
    }

    public Optional<UserModel> findById(Long id){
        return userRepository.findById(id);
    }

    public UserModel updateUserById(UserModel userModel,Long id){
        UserModel user=userRepository.findById(id).get();
        user.setId(id);
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setEmail(userModel.getEmail());
        userRepository.save(user);
        return user;
    }
    public Boolean deleteById(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
