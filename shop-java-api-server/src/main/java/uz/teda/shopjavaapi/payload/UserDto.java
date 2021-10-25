package uz.teda.shopjavaapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.teda.shopjavaapi.entity.Client;
import uz.teda.shopjavaapi.entity.Role;

import java.util.List;

@Data

public class UserDto {
    private Integer id;
    private String fio;
    private String username;
    private String phoneNumber;
    private String userpass;
    private String userPrepass;
    private List<Role> roles;
    private int DelFlag;


}
