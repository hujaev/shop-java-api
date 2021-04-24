package uz.teda.shopjavaapi.repository;

import com.uz.shopapi.Model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value ="SELECT id,client_id,username,userpass,fio,del_flag FROM `user` WHERE username=:username" ,nativeQuery = true)
    User getUserByUsername(@Param("username") String username);

}
