package uz.teda.shopjavaapi.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "s_brend")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Brend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nom")
    private String nom;


}
