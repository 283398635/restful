package com.newer.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.newer.dao.CarMapper;
import com.newer.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true,rollbackFor = Exception.class)
public class CarService {

    @Autowired
    private CarMapper carMapper;

    /**
     * 查询
     * @return
     */
    public List<Car> findCar(){
        return carMapper.findCar();
    }

    /**
     * 增加
     * @param car
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int addCar(Car car){
        return carMapper.addCar(car);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(Integer id){
        return carMapper.delete(id);
    }

    /**
     * 修改
     * @param car
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int update(Car car){
        return carMapper.updCar(car);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    public Car findById(Integer id){
        return carMapper.findById(id);
    }

    /**
     * 条件查询
     * @param name
     * @param beginDate
     * @param endDate
     * @return
     */
    public List<Car> queryList(String name,Date beginDate,Date endDate){
        return carMapper.queryCarList(name,beginDate,endDate);
    }

}
