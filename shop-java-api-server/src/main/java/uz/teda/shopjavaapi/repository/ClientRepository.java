package uz.teda.shopjavaapi.repository;

import com.uz.shopapi.Model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    Client findClientById(Integer id);

}
