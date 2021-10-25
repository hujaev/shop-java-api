package uz.teda.shopjavaapi.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.teda.shopjavaapi.entity.Role;
import uz.teda.shopjavaapi.entity.RoleName;

@RepositoryRestResource(path = "/role")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(RoleName name);
}
