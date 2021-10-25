package uz.teda.shopjavaapi.repository.rest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.teda.shopjavaapi.entity.Role;
import uz.teda.shopjavaapi.entity.RoleName;

@Projection(name = "/customRole", types = Role.class)
public interface CustomRole {
    Integer getId();
    RoleName getName();
}
