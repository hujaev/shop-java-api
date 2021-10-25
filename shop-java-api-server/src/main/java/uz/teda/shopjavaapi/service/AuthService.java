package uz.teda.shopjavaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.teda.shopjavaapi.entity.RoleName;
import uz.teda.shopjavaapi.entity.User;
import uz.teda.shopjavaapi.payload.ApiResponse;
import uz.teda.shopjavaapi.payload.UserDto;
import uz.teda.shopjavaapi.repository.UserRepository;
import uz.teda.shopjavaapi.repository.rest.RoleRepository;


import java.util.Collections;
import java.util.UUID;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    PasswordEncoder passwordEncoder;


    public ApiResponse register(UserDto request) {
        if (request.getUserpass().equals(request.getUserPrepass())) {
            boolean exists = userRepository.existsByPhoneNumber(request.getPhoneNumber());
            if (!exists) {

                User user = new User(request.getFio(),

                        request.getPhoneNumber(),
                        passwordEncoder.encode(request.getUserpass()),
                        Collections.singletonList(roleRepository.findByName(RoleName.Admin))
                );
                userRepository.save(user);
                return new ApiResponse("Ro'yxatdan o'tdi", true);
            }
            return new ApiResponse("Bunday tel raqamli user mavjud", false);
        }
        return new ApiResponse("Parol va takroriy parol mutanosib emas", false);
    }

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) {
        System.out.println(phoneNumber);
        return userRepository.findByPhoneNumber(phoneNumber).orElseThrow(() -> new UsernameNotFoundException("phoneNumber"));
    }

    public User loadUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Id"));
    }

}
