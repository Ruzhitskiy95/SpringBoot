package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CarModel> findAll() {
        return jdbcTemplate.query("SELECT * from cartable", BeanPropertyRowMapper.newInstance(CarModel.class));
    }


    public int insert(CarModel carModel) {
        return jdbcTemplate.update("INSERT INTO cartable (carmodel, carmounth, cartypebody," +
                        " carengine, cartransmission, carenginevolume) VALUES(?,?,?,?,?,?)",
                new Object[] { carModel.getCarModel(), carModel.getCarMonth(), carModel.getCarTypeBody(),
                carModel.getCarEngine(), carModel.getCarTransmission(), carModel.getCarEngineVolume()});
    }

    public int update(CarModel carModel) {
        return jdbcTemplate.update("UPDATE cartable SET carmodel = ?, carmounth = ?, cartypebody = ?," +
                        " carengine = ?, cartransmission = ?, carenginevolume = ? WHERE id = ?",
                new Object[] { carModel.getCarModel(), carModel.getCarMonth(), carModel.getCarTypeBody(),
                        carModel.getCarEngine(), carModel.getCarTransmission(), carModel.getCarEngineVolume(), carModel.getId()});
    }


    public void deleteById(Integer id) {
        jdbcTemplate.update("DELETE FROM cartable WHERE id=?", id);
    }
}
