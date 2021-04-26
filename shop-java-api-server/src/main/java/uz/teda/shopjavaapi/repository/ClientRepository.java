package uz.teda.shopjavaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.teda.shopjavaapi.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    Client findClientById(Integer id);

}
