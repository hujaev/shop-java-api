package uz.teda.shopjavaapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.teda.shopjavaapi.dto.UserDto;
import uz.teda.shopjavaapi.service.UserService;

import java.util.List;

@RestController
@RequestMapping( value="/application/json")
public class Controller {
    @Autowired
    UserService userService;
    @GetMapping(value = "/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> list = userService.getUsers();
        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<UserDto> getUser(@RequestBody UserDto user) {
        UserDto userDto = userService.checkUser(user);
        return ResponseEntity.ok(userDto);
    }
    /*@PutMapping(path = "/user")
    public ResponseEntity<UserDto> editAsos(@RequestBody UserDto asosDto) {
        return ResponseEntity.ok(UserService.editAsos(asosDto));
    }*/


}

