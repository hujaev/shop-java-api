package uz.teda.shopjavaapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.teda.shopjavaapi.Request.RequestMainSlave;
import uz.teda.shopjavaapi.Response.ResponseOdMainSlave;
import uz.teda.shopjavaapi.entity.Main;
import uz.teda.shopjavaapi.entity.SlaveMain;
import uz.teda.shopjavaapi.repository.MainRepository;
import uz.teda.shopjavaapi.repository.MainSlaveRepository;
import uz.teda.shopjavaapi.service.MainService;

import java.util.ArrayList;
import java.util.List;


@Service
public class MainServiceImpl implements MainService {

    @Autowired
    MainRepository mainRepository;

    @Autowired
    MainSlaveRepository mainSlaveRepository;


    @Override
    public Integer addMain(String serial) {
        Integer Id=0;
        Main main1=mainRepository.selectMain(serial);
        if (main1==null){
            Main main=new Main();
//        BeanUtils.copyProperties(mainDto, main);
            main.setSerial(serial);
            Id=mainRepository.save(main).getId();
        } else{
            Id=main1.getId();
        }

        SlaveMain mainslave1=mainSlaveRepository.selectMainSlave(Id);
        if (mainslave1==null){
            return Id;
        } else  {
            return -mainslave1.getId();
        }
    }

    @Override
    public Integer checkMainSerial(String serial, Integer check) {
       Main main = mainRepository.selectMain(serial);
       if (main ==null){
           if (check == 1){
               Main main1=new Main();
               main1.setSerial(serial);
              return mainRepository.save(main1).getId();
           }else {
               return 777;
           }
       }
       else {
           return main.getId();
       }
    }

    @Override
    public List<ResponseOdMainSlave> getMainSlaves(int slaveid) {
        List<ResponseOdMainSlave> responseOdMainSlaves=new ArrayList<>();
        List<SlaveMain> listMainSlave=mainSlaveRepository.findAll();
        //if (listMainSlave!=null){
            for (SlaveMain slaveMain : listMainSlave) {

                Main main = mainRepository.findById(slaveMain.getMain_id()).get();
                if(main==null){
                    return  responseOdMainSlaves;
                }
                if (main != null && slaveMain.getSlave_id() == slaveid) {
                    ResponseOdMainSlave responseOdMainSlave = new ResponseOdMainSlave();
                    responseOdMainSlave.setId(slaveMain.getId());
                    responseOdMainSlave.setMain_id(slaveMain.getMain_id());
                    responseOdMainSlave.setSlave_id(slaveMain.getSlave_id());
                    responseOdMainSlave.setSerial(main.getSerial());
                    responseOdMainSlaves.add(responseOdMainSlave);
                }
            } return  responseOdMainSlaves;


    }

    @Override
    public Integer addMainSlave(RequestMainSlave requestMainSlave) {


        Main main = mainRepository.selectMain(requestMainSlave.getSerial());

        //if (main!=null){

            SlaveMain slaveMain= mainSlaveRepository.findSlaveMainBySerial(main.getId());
            if(slaveMain==null){
                slaveMain=new SlaveMain();
                slaveMain.setDel_flag(1);
                slaveMain.setMain_id(main.getId());
                slaveMain.setSlave_id(requestMainSlave.getSlave_id());
                Integer lastMainSlave = mainSlaveRepository.save(slaveMain).getId();
                return lastMainSlave;
            }else{
                return -slaveMain.getId();
            }
        //}  return 99999;
    }

    @Override
    public Integer deleteMainSlave(Integer id) throws Exception {
        SlaveMain slaveMain=mainSlaveRepository.findById(id).get();
        if (slaveMain==null) throw new Exception();
        mainSlaveRepository.delete(slaveMain);
        return id;
    }
}
