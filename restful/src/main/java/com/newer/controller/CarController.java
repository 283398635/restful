package com.newer.controller;

import com.newer.pojo.Car;
import com.newer.service.CarService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

//将返回的对象变更成JSON对象
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:8080",maxAge = 3600)
public class CarController {

    @Autowired
    private CarService carService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "car",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Car>> query(
            @RequestParam(value = "name",required = false)String name,
            @RequestParam(value = "beginDate",required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
            @RequestParam(value = "endDate",required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
    ){

        List<Car> carList = carService.queryList(name,beginDate,endDate);

        if(carList.isEmpty()){

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(carList,HttpStatus.OK);
    }

    /**
     * 增加
     *
     * @return
     */

    @RequestMapping(value = "car",method = RequestMethod.POST)
    public ResponseEntity<?> addCar(@RequestBody Car car){
        /*Car car = new Car();
        car.setName(name);
        car.setPrice(price);
        car.setSale_date(sale_date);*/
        int i = carService.addCar(car);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    @RequestMapping(value = "car/{id}",method = RequestMethod.DELETE)
    public  ResponseEntity<?> queryById(@PathVariable(value = "id")Integer id){
        int fluRows  = carService.delete(id);
        return new ResponseEntity<>(fluRows,HttpStatus.OK);
    }


    /**
     * 修改
     * @return
     */

    @RequestMapping(value = "car",method = RequestMethod.PUT)
    public ResponseEntity<?> updCar(@RequestBody Car car){
        int i = carService.update(car);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping(value = "car/{id}",method = RequestMethod.GET)
    public ResponseEntity<Car> findById(@PathVariable(value = "id") Integer id){
        Car car = carService.findById(id);
        return new ResponseEntity<>(car,HttpStatus.OK);
    }



}
