package uz.teda.shopjavaapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.teda.shopjavaapi.payload.HaridorDto;
import uz.teda.shopjavaapi.entity.Haridor;
import uz.teda.shopjavaapi.repository.HaridorRepository;
import uz.teda.shopjavaapi.service.HaridorService;

import java.util.ArrayList;
import java.util.List;

@Service
public class HaridorSeviceImpl implements HaridorService {

    @Autowired
    HaridorRepository haridorRepository;

    @Override
    public List<HaridorDto> getHaridor(Integer clientId) {
       List<Haridor> list=haridorRepository.findAll();
       List<HaridorDto> haridorDtoList=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).getClient_id()==clientId){
                HaridorDto add=new HaridorDto();
                add.setId(list.get(i).getId());
                add.setClientId(list.get(i).getClient_id());
                add.setNom(list.get(i).getNom());
                add.setManzil(list.get(i).getManzil());
                add.setAdress(list.get(i).getAdress());
                haridorDtoList.add(add);
            }
        }
        return haridorDtoList;
    }
}
