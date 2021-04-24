package uz.teda.shopjavaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @Column(name ="client_id" )
    Integer client_id;

    @Column(name = "username")
    String username;

    @Column(name = "userpass")
    String userpass;

    @Column(name = "fio")
    String fio;

    @Column(name = "del_flag")
    Integer del_flag;


}
