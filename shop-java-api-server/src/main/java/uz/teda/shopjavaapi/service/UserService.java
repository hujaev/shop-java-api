package uz.teda.shopjavaapi.service;


import com.uz.shopapi.Model.dto.UserDto;

import java.util.List;


public interface UserService {
    List<UserDto> getUsers();
    UserDto checkUser(UserDto user);

}
