package uz.teda.shopjavaapi.service;


import uz.teda.shopjavaapi.dto.UserDto;

import java.util.List;


public interface UserService {
    List<UserDto> getUsers();
    UserDto checkUser(UserDto user);

}
