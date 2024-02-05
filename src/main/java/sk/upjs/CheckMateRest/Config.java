package sk.upjs.CheckMateRest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.CheckMateRest.storage.dao.*;
import sk.upjs.CheckMateRest.storage.mysql.*;
import sk.upjs.CheckMateRest.storage.triedy.Test;

@Configuration
public class Config {

    private final JdbcTemplate jdbcTemplate;


    public Config(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    public UserDao getUserDao(UserDao userDao){
        return new MysqlUserDao(jdbcTemplate);
    }

    @Bean
    public StationDao getStationDao(StationDao stationDao){
        return  new MysqlStationDao(jdbcTemplate);
    }

    @Bean
    public TestDao getTestDao(TestDao testDao){
        return new MysqlTestDao(jdbcTemplate);
    }

    @Bean
    public CodeDAO getCodeDAO(CodeDAO codeDAO){
        return new MysqlCodeDAO(jdbcTemplate);
    }

    @Bean
    public CardDao getCardDao(CardDao cardDao){
        return new MysqlCardDao(jdbcTemplate);
    }

    @Bean
    public ShiftDao getShiftDao(ShiftDao shiftDao){
        return new MysqlShiftDao(jdbcTemplate);
    }

    @Bean
    public UhsDao getUhsDao(UhsDao uhsDao){
        return new MysqlUhsDao(jdbcTemplate);
    }
}
