package uz.teda.shopjavaapi.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.teda.shopjavaapi.payload.AsosDto;
import uz.teda.shopjavaapi.entity.Asos;
import uz.teda.shopjavaapi.repository.AsosRepository;
import uz.teda.shopjavaapi.repository.HaridorRepository;
import uz.teda.shopjavaapi.service.AsosService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AsosServiceImpl implements AsosService {

    @Autowired
    AsosRepository asosRepository;
    @Autowired
    HaridorRepository haridorRepository;
   /* @Autowired
    Bot bot;*/

    @Override
    public AsosDto getAsos(AsosDto asosDto) {

        Asos selectAsos = asosRepository.selectAsos(asosDto.getUserId(), asosDto.getDiler_id());

        if(selectAsos==null){
            selectAsos=new Asos();
            if(asosDto.getId()!=null){
                selectAsos.setId(asosDto.getId());
            }
            selectAsos.setSana(LocalDate.now().toString());
            selectAsos.setDel_flag(1);
            selectAsos.setUser_id(asosDto.getUserId());
            selectAsos.setClient_id(asosDto.getClient_id());
            selectAsos.setDiler_id(asosDto.getDiler_id());
            selectAsos.setXodim_id(asosDto.getXodimId());
            selectAsos.setH_id(asosDto.getHaridorId());
            selectAsos.setSumma(asosDto.getSumma());
            selectAsos.setTur_oper(asosDto.getTur_oper());
            selectAsos.setSotuv_turi(asosDto.getSotuv_turi());
            asosRepository.save(selectAsos);
        }

        selectAsos = asosRepository.selectAsos(asosDto.getUserId(), asosDto.getDiler_id());


        asosDto.setId(selectAsos.getId());
        asosDto.setClient_id(selectAsos.getClient_id());
        asosDto.setUserId(selectAsos.getUser_id());
        asosDto.setXodimId(selectAsos.getXodim_id());
        asosDto.setSana(selectAsos.getSana());
        asosDto.setDiler_id(selectAsos.getDiler_id());
        asosDto.setHaridorId(selectAsos.getH_id());
        asosDto.setTur_oper(selectAsos.getTur_oper());
        asosDto.setSumma(selectAsos.getSumma());
        asosDto.setSotuv_turi(selectAsos.getSotuv_turi());

        return asosDto;
    }


    @Override
    public List<AsosDto> get(AsosDto asosDto) {
        List<Asos> list=asosRepository.selectAsosGet(asosDto.getClient_id());
        List<AsosDto> answers=new ArrayList<>();
        if (list.isEmpty()){
            Asos newasos=new Asos();
            newasos.setClient_id(asosDto.getClient_id());
            newasos.setDel_flag(asosDto.getDel_flag());
            if (asosDto.getDiler_id().equals(null)){
                newasos.setDiler_id(0);
            }
            else {
                newasos.setDiler_id(asosDto.getDiler_id());
            }
            if (asosDto.getDollar().equals(null)){
                newasos.setDollar(0);
            }
            else{
                newasos.setDollar(asosDto.getDollar());
            }
            if (asosDto.getHaridorId().equals(null)){
                newasos.setH_id(0);
            }
            else {
                newasos.setH_id(asosDto.getHaridorId());
            }
            if (asosDto.getKol().equals("null")){

                newasos.setKol(0);
            }
            else {
                newasos.setKol(asosDto.getKol());
            }
            if (asosDto.getKurs().equals(null)){
                newasos.setKurs(0.0);
            }
            else {
                newasos.setKurs(asosDto.getKurs());
            }
            if (asosDto.getNomer().equals(null)){
                newasos.setNomer("");
            }
            else {
                newasos.setNomer(asosDto.getNomer());
            }
            if (asosDto.getSana().equals("") || asosDto.getSana().equals(null)){
                newasos.setSana(LocalDate.now().toString());
            }
            else {
                newasos.setSana(asosDto.getSana());
            }
            newasos.setSotuv_turi(asosDto.getSotuv_turi());
            newasos.setSum_d(asosDto.getSum_d());
            newasos.setSumma(asosDto.getSumma());
            newasos.setTur_oper(asosDto.getTur_oper());
            newasos.setUser_id(asosDto.getUserId());
            newasos.setXodim_id(asosDto.getXodimId());
            asosRepository.save(newasos);

        }


        list=asosRepository.selectAsosGet(asosDto.getClient_id());

        for (int i = 0; i < list.size(); i++) {
            Asos asos=list.get(i);
            AsosDto dto=new AsosDto();
            dto.setId(asos.getId());
            dto.setClient_id(asos.getClient_id());
            dto.setDel_flag(asos.getDel_flag());
            dto.setDiler_id(asos.getDiler_id());
            dto.setDollar(asos.getDollar());
            dto.setHaridorId(asos.getH_id());
            dto.setKol(asos.getKol());
            dto.setKurs(asos.getKurs());
            dto.setNomer(asos.getNomer());
            dto.setSana(asos.getSana());
            dto.setSotuv_turi(asos.getSotuv_turi());
            dto.setSum_d(asos.getSum_d());
            dto.setSumma(asos.getSumma());
            dto.setTur_oper(asos.getTur_oper());
            dto.setUserId(asos.getUser_id());
            dto.setXodimId(asos.getXodim_id());
            answers.add(dto);
        }



        return answers;
    }


    @Override
    public AsosDto put(AsosDto asosDto) {
        Asos newasos=new Asos();


//        newasos.setClient_id(asosDto.getClientId());

//        if (asosDto.getDel_flag().equals(null)){
//            newasos.setDel_flag(1);
//        }
//        else {
//            newasos.setDel_flag(asosDto.getDel_flag());
//        }
//        if (asosDto.getDilerId().equals(null)){
//            newasos.setDiler_id(0);
//        }
//        else {
//            newasos.setDiler_id(asosDto.getDilerId());
//        }
//        if (asosDto.getDollar().equals(null)){
//            newasos.setDollar(0);
//        }
//        else {
//            newasos.setDollar(asosDto.getDollar());
//        }
//        if (asosDto.getHaridorId().equals(null)){
//            newasos.setH_id(0);
//        }
//        else {
//            newasos.setH_id(asosDto.getHaridorId());
//        }
//        if (asosDto.getKol().equals(null)){
//            newasos.setKol(0);
//        }
//        else {
//            newasos.setKol(asosDto.getKol());
//        }
//        if (asosDto.getKurs().equals(null)){
//            newasos.setKurs(0.0);
//        }
//        else {
//            newasos.setKurs(asosDto.getKurs());
//        }
//        if (asosDto.getNomer().equals(null)) {
//            newasos.setNomer(asosDto.getNomer());
//        }
//        else {
//            newasos.setNomer(asosDto.getNomer());
//        }
//        if (asosDto.getSana().equals("") || asosDto.getSana().equals(null)){
//            newasos.setSana(LocalDate.now().toString());
//        }
//        else {
//            newasos.setSana(asosDto.getSana());
//        }
//
//        if (asosDto.getSotuvTuri().equals(null)){
//            newasos.setSotuv_turi(1);
//        }
//        else {
//            newasos.setSotuv_turi(asosDto.getSotuvTuri());
//        }
//        if (asosDto.getSum_d().equals(null)){
//            newasos.setSum_d(0.0);
//        }
//        else {
//            newasos.setSum_d(asosDto.getSum_d());
//        }
//        if (asosDto.getSumma().equals(null)){
//            newasos.setSumma(0.0);
//        }
//        else {
//            newasos.setSumma(asosDto.getSumma());
//        }
//        if (asosDto.getTurOper().equals(null)){
//            newasos.setTur_oper(1);
//        }
//        else {
//            newasos.setTur_oper(asosDto.getTurOper());
//        }
//        if (asosDto.getXodimId().equals(null)){
//            newasos.setXodim_id(asosDto.getUserId());
//        }
//        else {
//            newasos.setXodim_id(asosDto.getXodimId());
//        }

        BeanUtils.copyProperties(asosDto, newasos);

        newasos.setUser_id(asosDto.getUserId());
        newasos.setXodim_id(asosDto.getXodimId());

        Asos asos = asosRepository.save(newasos);
//        asosDto.setId(newasos.getId());
        BeanUtils.copyProperties(asos, asosDto);
        return asosDto;

    }



    @Override
    public void block(AsosDto asosDto) {
        Asos asos=asosRepository.findById(asosDto.getId()).get();
       /* Haridor haridor=haridorRepository.findById(asos.getH_id()).get();
        SendMessage sendMessage=new SendMessage();
        sendMessage.setChatId(haridor.getChat_id());
        sendMessage.setText("Haridingiz uchun raxmat\nSumma:"+ asos.getSumma()+" So'm");
        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }*/
        asos.setDiler_id(1);
        asosRepository.save(asos);
    }

    @Override
    public AsosDto editAsos(AsosDto asosDto) {
        Asos asos = asosRepository.findById(asosDto.getId()).get();
        if (asos != null){

            BeanUtils.copyProperties(asosDto, asos);
            asosRepository.save(asos);
        }
        return asosDto;
    }


//    @Override
//    public void save(AsosDto asosDto){
//        Asos asos=new Asos();
//        if(asosDto.getId()!=null){
//            asos.setId(asosDto.getId());
//        }
//        asos.setSana(LocalDate.now().toString());
//        asos.setUser_id(asosDto.getUserId());
//        asos.setClient_id(asosDto.getClientId());
//        asos.setDiler_id(asosDto.getDilerId());
//        asos.setXodim_id(asosDto.getXodimId());
//        asos.setSumma(asosDto.getSumma());
//        asos.setTur_oper(asosDto.getTurOper());
//        asosRepository.save(asos);
//    }



}
