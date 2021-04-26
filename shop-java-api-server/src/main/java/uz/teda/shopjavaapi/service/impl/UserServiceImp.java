package uz.teda.shopjavaapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.teda.shopjavaapi.dto.UserDto;
import uz.teda.shopjavaapi.entity.User;
import uz.teda.shopjavaapi.repository.UserRepository;
import uz.teda.shopjavaapi.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public List<UserDto> getUsers() {
        List<UserDto> list=new ArrayList<>();
        List<User> users=userRepository.findAll();
        for (int i = 0; i < users.size(); i++) {
            UserDto user=new UserDto();
            if(users.get(i).getId()!=null){
                user.setId(users.get(i).getId());
            }
            if(users.get(i).getClient_id()!=null){
                user.setClientId(users.get(i).getClient_id());
            }
            if(users.get(i).getUsername()!=null) {
                user.setUsername(users.get(i).getUsername());
            }
            if(users.get(i).getUserpass()!=null){
                user.setUserpass(users.get(i).getUserpass());
            }
            if(users.get(i).getFio()!=null){
                user.setFio(users.get(i).getFio());
            }
            if(users.get(i).getDel_flag()!=null){
                user.setDelFlag(users.get(i).getDel_flag());
            }

            list.add(user);
        }
        return list;
    }


    @Override
    public UserDto checkUser(UserDto checkuser) {
        User user=userRepository.getUserByUsername(checkuser.getUsername());
        if(user!=null){
            if(checkuser.getUserpass().equals(user.getUserpass()) && checkuser.getUserpass().equals(user.getUserpass())) {
                if(user.getId()!=null){
                    checkuser.setId(user.getId());
                }
                if(user.getClient_id()!=null) {
                    checkuser.setClientId(user.getClient_id());
                }
                if(user.getFio()!=null) {
                    checkuser.setFio(user.getFio());
                }
                if(user.getDel_flag()!=null) {
                    checkuser.setDelFlag(user.getDel_flag());
                }
            }
        }
        return checkuser;
    }



}
