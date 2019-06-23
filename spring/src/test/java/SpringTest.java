import cn.itcast.core.BeanFactory;
import cn.itcast.core.SpringConfig;
import cn.itcast.model.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Driver;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SpringTest {

    @Test
    public void test1(){
        Driver driver = (Driver) BeanFactory.getBean("Driver");
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        User bean = context.getBean(User.class);
        System.out.println(bean);
        ComboPooledDataSource dataSource = new ComboPooledDataSource("");
    }
}
