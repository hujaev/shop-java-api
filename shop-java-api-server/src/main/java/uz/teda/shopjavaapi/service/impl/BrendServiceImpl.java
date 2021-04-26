package uz.teda.shopjavaapi.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.teda.shopjavaapi.dto.BrendDto;
import uz.teda.shopjavaapi.entity.Brend;
import uz.teda.shopjavaapi.repository.BrendRepository;
import uz.teda.shopjavaapi.service.BrendService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrendServiceImpl implements BrendService {

    @Autowired
    BrendRepository BrendRepository;

    @Override
    public List<BrendDto> get() {
        List<Brend> list=BrendRepository.findAll();
        List<BrendDto> answer=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            BrendDto brendDto =new BrendDto() ;
                BeanUtils.copyProperties(list.get(i),brendDto);
                answer.add(brendDto);
        }
        return answer;
    }
}
