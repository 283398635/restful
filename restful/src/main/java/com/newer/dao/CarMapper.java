package com.newer.dao;

import com.newer.pojo.Car;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CarMapper {

    @Select("select id,name,price,sale_date from car")
    List<Car> findCar();

    @Insert("insert into car (name,price,sale_date) values(#{name},#{price},#{sale_date})")
    int addCar(Car car);

    @Update("update car set name=#{name},price=#{price},sale_date=#{sale_date} where id=#{id}")
    int updCar(Car car);

    @Delete("delete from car where id=#{id}")
    int delete(Integer id);

    @Select("select id,name,price,sale_date from car where id=#{id}")
    Car findById(Integer id);

    List<Car> queryCarList(@Param("name")String name,
                           @Param("beginDate")Date beginDate,
                            @Param("endDate") Date endDate);


}
