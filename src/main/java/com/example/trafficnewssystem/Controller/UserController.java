package com.example.trafficnewssystem.Controller;

import com.example.trafficnewssystem.Model.UserDto;
import com.example.trafficnewssystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDto userDto){
        userDto = userService.registerUser(userDto);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@RequestBody UserDto userDto ,
                                     @PathVariable long id){
        userDto = userService.updateUser(userDto,id);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@RequestBody UserDto userDto,
                                     @PathVariable long id) throws Exception{
        boolean result = userService.deleteUser(userDto,id);
        return ResponseEntity.ok(result);
    }
}
