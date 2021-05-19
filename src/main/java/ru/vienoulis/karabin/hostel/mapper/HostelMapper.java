package ru.vienoulis.karabin.hostel.mapper;

import org.apache.ibatis.annotations.Select;
import ru.vienoulis.karabin.hostel.entity.AdminHostelName;
import ru.vienoulis.karabin.hostel.entity.Hostel;

import java.util.List;

public interface HostelMapper {

    String GET_ALL_HOSTEL = "SELECT * FROM HOSTEL";
    String GET_ADMIN_AND_HOSTEL = "SELECT a.name, h.local_name " +
            "FROM admin a RIGHT JOIN hostel h on h.id = a.hostel_id;";

    @Select(GET_ALL_HOSTEL)
    List<Hostel> getAllHostel();

    @Select(GET_ADMIN_AND_HOSTEL)
    List<AdminHostelName> getAdminAndHostel();
}
