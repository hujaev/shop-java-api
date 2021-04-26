package uz.teda.shopjavaapi.service;


import uz.teda.shopjavaapi.Request.RequestMainSlave;
import uz.teda.shopjavaapi.Response.ResponseOdMainSlave;

import java.util.List;

public interface MainService {

    Integer addMain(String serial);

   Integer checkMainSerial(String serial, Integer check);

    List<ResponseOdMainSlave> getMainSlaves(int slaveid);

    Integer addMainSlave(RequestMainSlave requestMainSlave);

    Integer deleteMainSlave(Integer id) throws Exception;
}
