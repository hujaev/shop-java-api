package uz.teda.shopjavaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.teda.shopjavaapi.entity.Kat;

public interface KatRepository extends JpaRepository<Kat,Integer> {

}