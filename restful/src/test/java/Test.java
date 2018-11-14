import com.newer.pojo.Car;
import com.newer.service.CarService;
import net.sf.json.JSONSerializer;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    private CarService carService;

    @Before
    public void init(){
        ApplicationContext acx = new ClassPathXmlApplicationContext("applicationContext.xml");
        CarService carService = acx.getBean("carService", CarService.class);
    }

    @org.junit.Test
    public void test(){
        List<Car> carList = carService.queryList("拉里", null, null);
        System.out.println(JSONSerializer.toJSON(carList));
    }
}