package uz.teda.shopjavaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.teda.shopjavaapi.entity.User;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

  //ser getUserByUsernameOrPhoneNumber(@Param("username") String username,@Param("PhoneNumber")String PhoneNumber);
    boolean existsByPhoneNumber(String PhoneNumber);
    Optional<User> findByPhoneNumber(String PhoneNumber);
}
