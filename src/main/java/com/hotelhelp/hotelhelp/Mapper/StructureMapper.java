package com.hotelhelp.hotelhelp.Mapper;

import com.hotelhelp.hotelhelp.domain.Structure;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StructureMapper {

    @Select("SELECT * FROM `t_user`  WHERE   (TO_DAYS(p_value) - TO_DAYS(NOW())) < 10 AND    (TO_DAYS(p_value) - TO_DAYS(NOW())) >1 ;")
    List<Structure> findPid();

}
