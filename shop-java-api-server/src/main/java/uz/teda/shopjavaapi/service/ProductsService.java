package uz.teda.shopjavaapi.service;

import uz.teda.shopjavaapi.payload.ProductDto;
import uz.teda.shopjavaapi.payload.ProductsDto;

import java.util.List;

public interface ProductsService {

    List<ProductsDto> getProducts(Integer type, Integer clientId);
    Integer addProduct(ProductDto productDto);
    List<ProductDto> getProductList(Integer clientId);
    void del(Integer id);

    Integer editproduct(ProductDto productDto);
}
