package uz.teda.shopjavaapi.service;

import uz.teda.shopjavaapi.payload.HaridorDto;

import java.util.List;

public interface HaridorService {
    List<HaridorDto> getHaridor(Integer clientId);
}
