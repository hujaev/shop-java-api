package uz.teda.shopjavaapi.service;

import uz.teda.shopjavaapi.dto.DillerDto;

import java.util.List;

public interface DillerService {
    List<DillerDto> get(Integer clientid);
}
