package uz.teda.shopjavaapi.service;

import uz.teda.shopjavaapi.payload.DillerDto;

import java.util.List;

public interface DillerService {
    List<DillerDto> get(Integer clientid);
}
