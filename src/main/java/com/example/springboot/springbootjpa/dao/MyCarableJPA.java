package com.example.springboot.springbootjpa.dao;

import com.example.springboot.springbootjpa.model.CarModelJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public interface MyCarableJPA extends JpaRepository<CarModelJPA, Long>, CrudRepository<CarModelJPA, Long> {

    CarModelJPA save(CarModelJPA carModelJPA);

    List<CarModelJPA> findAll();

    List<CarModelJPA> findAllByCarEngine(String engine);

    List<CarModelJPA> findByCarTransmission(String transmission);

    List<CarModelJPA>findByCarMounthBetween(Integer from, Integer to);

    void deleteAllById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE cartable SET carmodel = :model, carmounth = :mounth, cartypebody = :typebody, carengine = :engine, cartransmission = :transmission, carenginevolume = :volume WHERE id = :id", nativeQuery = true)

    void updateById(@Param("model") final String model,
                    @Param("mounth") final Integer mounth,
                    @Param("typebody") final String typebody,
                    @Param("engine") final Integer engine,
                    @Param("transmission") final String transmission,
                    @Param("volume") final Integer volume,
                    @Param("id") final Integer id);

}
