package uz.teda.shopjavaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity(name = "s_tovar")
@EntityListeners(AuditingEntityListener.class)
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Integer id;
    @Column
    private   String nom;
    @Column
    private  String nom_ru;
    @Column
    private  String nom_sh;
    @Column
    private  String shtrix;
    @Column
    private  String shtrix_in;
    @Column
    private Integer tz_id;
      @Column
      private  String shtrix_full;
    @Column
    private   String shtrix1;
    @Column
    private  String shtrix2;
    @Column
    private Integer kat;
    @Column
    private Integer brend;
    @Column
    private  Integer papka;
    @Column
    private  String qr;
    @Column
    private  Integer shtrixkod;
    @Column
    private  String qrkod;
    @Column
    private Integer izm_id;
    @Column
    private Integer del_flag;
    @Column
    private Integer client_id;
    @Column
    private Double sotish;
    @Column
    private  Double ulg1;
    @Column
    private  Double ulg2;
    @Column
    private  Double ulg1_pl;
    @Column
    private  Double ulg2_pl;
    @Column
    private  Double bank;
    @Column
    private  Double sena;
    @Column
    private  Integer kol_in;
    @Column
    private Double sena_d;
    @Column
    private  Double sena_in_d;
    @Column
    private   Integer tkol;
    @Column
    private  Integer tkol_in;
    @Column
    private  Integer user_id;
    @Column
    private  Integer seriya;

 private  Integer kg;



}
