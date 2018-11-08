package com.hotelhelp.hotelhelp.service.impl;

import com.hotelhelp.hotelhelp.Mapper.StructureMapper;
import com.hotelhelp.hotelhelp.domain.Structure;
import com.hotelhelp.hotelhelp.service.ScheduleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorizationManageImpl implements ScheduleTask {

    @Autowired
    StructureMapper structureMapper;
    public final static  long SECOND = 1000;
   // private  static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Override
    @Scheduled(fixedRate = SECOND * 5)
    public void policeAuthorizationManage() {
        List<Structure> pids = structureMapper.findPid();

    }
}
