package com.example.trafficnewssystem.Service;

import com.example.trafficnewssystem.Entity.Users;
import com.example.trafficnewssystem.Model.UserDto;
import com.example.trafficnewssystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDto registerUser(UserDto userDto) {

        Users register = new Users();// register is a Entity object
        register.setNews(userDto.getNews());
        register.setTime(userDto.getTime());

        register = userRepository.save(register);
        userDto.setId(register.getId());
        return userDto;
    }


    public UserDto updateUser(UserDto userDto, long id) {
        Optional<Users> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            Users users = userOptional.get();
            //users.setId(userDto.getId());
            users.setNews(userDto.getNews());
            users.setTime(userDto.getTime());
            users = userRepository.save(users);
            userDto.setId(users.getId());

            return userDto;
        }
        return userDto;
    }


    public boolean deleteUser(UserDto userDto, long id) throws Exception {
        Optional<Users> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            Users users = userOptional.get();
            userRepository.delete(users);

        } else {
            throw new Exception("User not found");
        }

        return true;
    }

}

