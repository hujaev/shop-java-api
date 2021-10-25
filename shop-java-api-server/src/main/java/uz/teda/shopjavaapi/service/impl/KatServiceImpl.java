package uz.teda.shopjavaapi.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.teda.shopjavaapi.payload.KatDto;
import uz.teda.shopjavaapi.entity.Kat;
import uz.teda.shopjavaapi.repository.KatRepository;
import uz.teda.shopjavaapi.service.KatService;

import java.util.ArrayList;
import java.util.List;

@Service
public class KatServiceImpl implements KatService {

    @Autowired
    KatRepository katRepository;

    @Override
    public List<KatDto> get() {
        List<Kat> list=katRepository.findAll();
        List<KatDto> answer=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
                KatDto KatDto =new KatDto() ;
                BeanUtils.copyProperties(list.get(i),KatDto);
                answer.add(KatDto);
        }
        return answer;
    }
}
