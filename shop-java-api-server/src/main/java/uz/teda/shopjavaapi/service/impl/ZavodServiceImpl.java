package uz.teda.shopjavaapi.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.teda.shopjavaapi.dto.ZavodDto;
import uz.teda.shopjavaapi.entity.Zavod;
import uz.teda.shopjavaapi.repository.ZavodRepository;
import uz.teda.shopjavaapi.service.ZavodService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZavodServiceImpl implements ZavodService {

    @Autowired
    ZavodRepository zavodRepository;

    @Override
    public List<ZavodDto> get() {
        List<Zavod> list=ZavodRepository.findAll();
        List<ZavodDto> answer=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            ZavodDto ZavodDto =new ZavodDto() ;
                BeanUtils.copyProperties(list.get(i),ZavodDto);
                answer.add(ZavodDto);
        }
        return answer;
    }
}
