package uz.teda.shopjavaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "s_haridor")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Haridor implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @Column
    Integer client_id;
    @Column
    String nom;
    @Column
    String adress;
    @Column
    String manzil;
    @Column
    Long chat_id;
    @Column
    String phone_number;


}
