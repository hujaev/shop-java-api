package uz.teda.shopjavaapi.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "main")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Main implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

    @Column(name = "status")
    private Integer status;

    @Column(name = "clientid")
    private Integer clientid;

    @Column(name = "serial")
    private  String serial;

    @Column(name = "qrkod")
    private Integer qrkod;

    @Column(name = "tovar_id")
    private Integer tovar_id;

    @Column(name = "tovarnom")
    private  String tovarnom;

    @Column(name = "text")
    private  String text;

    @Column(name = "rasm")
    private String rasm;

    @Column(name = "ovoz")
    private String ovoz;

    @Column(name = "tur_oper")
    private  Integer tur_oper;

    @Column(name = "parent_id")
    private Integer parent_id;

    @Column(name = "slave_id")
    private Integer slave_id;


}
