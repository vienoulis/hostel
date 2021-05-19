package ru.vienoulis.karabin.hostel.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import ru.vienoulis.karabin.hostel.mapper.AdminMapper;
import ru.vienoulis.karabin.hostel.mapper.HostelMapper;
import ru.vienoulis.karabin.hostel.mapper.UserMapper;

import javax.inject.Singleton;
import java.io.Reader;
import java.util.Objects;

@Slf4j
@Singleton
@Component
public class MapperService {
    private SqlSessionFactory sqlSessionFactory;

    public HostelMapper getHostelMapper() {
        return getSqlSessionFactory().openSession().getMapper(HostelMapper.class);
    }
    public AdminMapper getAdminMapper() {
        return getSqlSessionFactory().openSession().getMapper(AdminMapper.class);
    }
    public UserMapper getUserMapper() {
        return getSqlSessionFactory().openSession().getMapper(UserMapper.class);
    }

    @SneakyThrows
    private SqlSessionFactory getSqlSessionFactory() {
        if (Objects.isNull(sqlSessionFactory)) {
            Reader reader = Resources
                    .getResourceAsReader("schema/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }
        return sqlSessionFactory;
    }

}
