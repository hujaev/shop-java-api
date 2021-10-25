package uz.teda.shopjavaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "asos")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Asos implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @Column
    Integer client_id;

    @Column
    Integer user_id;
    @Column
    Integer h_id;

    @Column
    Integer xodim_id;

    @Column
    String sana;

    @Column

    Integer diler_id;

    @Column
    Integer tur_oper;

    @Column
    Double summa;

    @Column
    Integer sotuv_turi;
    @Column
    String nomer;
    @Column
    Integer del_flag;
    @Column
    Double kurs;
    @Column
    Double sum_d;
    @Column
    Integer  kol;
    @Column
    Integer  dollar;

}
