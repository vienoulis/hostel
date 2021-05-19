package ru.vienoulis.karabin.hostel.mapper;

import org.apache.ibatis.annotations.Select;
import ru.vienoulis.karabin.hostel.entity.Hostel;

import java.util.List;

public interface HostelMapper {

    String GET_ALL_HOSTEL = "SELECT * FROM HOSTEL";

    @Select(GET_ALL_HOSTEL)
    List<Hostel> getAllHostel();
}
