package uz.teda.shopjavaapi.service;

import com.uz.shopapi.Model.dto.DillerDto;

import java.util.List;

public interface DillerService {
    List<DillerDto> get(Integer clientid);
}
