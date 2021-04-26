package uz.teda.shopjavaapi.service;

import uz.teda.shopjavaapi.dto.AsosSlaveDto;
import uz.teda.shopjavaapi.dto.ProductsDto;

import java.util.List;

public interface AsosSlaveService {

    Integer addProducts(Integer delFlag, Integer asosId, Integer userId, ProductsDto productsDto);
    List<ProductsDto> listAddProducts(Integer asosid);

    Integer getAsosSlave(Integer delFlag, Integer tovarId, AsosSlaveDto asosSlaveDto);
    List<AsosSlaveDto> listGetAsosSlave(Integer tovarId);


    Integer addProducts2(Integer delFlag, Integer asosId, Integer userId, ProductsDto productsDto);
    Boolean delProducts(Integer delFlag, Integer asosId, Integer id);

   Boolean putProducts(ProductsDto productsDto);

}
