package uz.teda.shopjavaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //client- bu firma
    @ManyToMany

    @JoinTable(name = "user_client",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> client_id;


    private String username;
    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String userpass;

    @Column(nullable = false)
    private String fio;

    @Column(length = 1)
    private Integer del_flag;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;


    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;

    public <User> User(String fio, String phoneNumber, String userpass, List<Role> roles) {
        this.fio=fio;
        this.phoneNumber=phoneNumber;
        this.userpass=userpass;
        this.roles=roles;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return this.userpass;
    }


    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return isEnabled();
    }

    public User( String fio,String username,String phoneNumber, String userpass, List<Role> roles) {
      this.fio=fio;
      this.username=username;
        this.phoneNumber = phoneNumber;
       // this.client_id=client_id;
        this.userpass = userpass;
        this.roles = roles;
    }
}
