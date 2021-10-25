package uz.teda.shopjavaapi.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import uz.teda.shopjavaapi.entity.User;
import uz.teda.shopjavaapi.repository.UserRepository;
import uz.teda.shopjavaapi.repository.rest.RoleRepository;

@Component
public class DataLoader implements CommandLineRunner {
    final
    UserRepository userRepository;
    final
    RoleRepository roleRepository;

    final BCryptPasswordEncoder bCryptPasswordEncoder;



    @Value("always")
    private String ketmon;

    public DataLoader(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public void run(String... args) throws Exception {
        if (ketmon.equals("always")) {
            userRepository.save(new User(
                    "Zafarbek,Jumaniyozov,G'afur o'g'li",
                    "juzafarbek",
                    "998990983342",
                    bCryptPasswordEncoder.encode("123"),
                    roleRepository.findAll()
            ));
        }
    }
}
