package uz.teda.shopjavaapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DillerDto  {
    Integer id;
    String  nom;
    String tel;
    Integer client_id;



}
