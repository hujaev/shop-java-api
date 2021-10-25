package uz.teda.shopjavaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "asos_slave")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AsosSlave implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    @Column
  private   Integer tovar_id;

    @Column
  private   Integer asos_id;

    @Column
    private Integer user_id;

    @Column
    private String tovar_nom;

    @Column
    private Integer kol;
    @Column
    private Integer kolIn;

    @Column
    private Integer kolOst;

    @Column
    private Integer kolInOst;

    @Column
    private  Double summa;

    @Column
    private    Double summa_in;

    @Column
    private    Double summa_all;

    @Column
    private  Double sotish;
    @Column
    private  Double sotish_in;

    @Column
    private     Double sena;

    @Column
    private   Double sena_in;
// asos_id,del_flag,kol_ost,kol_in_ost,suma_all_ost,zakaz_si

    @Column
    private  Integer turi;

    @Column
    private  Integer subkod;
    @Column
    private   Integer del_flag;

    @Column
    private   Double summa_all_ost;

    @Column
    private  Double zakaz_see;

    @Column
    private     Integer resept;

    @Column
    private Integer izm_id;
    @Column
    private Integer izm1;



}
