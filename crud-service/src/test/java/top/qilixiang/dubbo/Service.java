package top.qilixiang.dubbo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Service.class);

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-cfg.xml");
            context.start();
        }catch (Exception e){
            LOGGER.error("spring error",e);
        }

        synchronized (Service.class){
            while (true){
                try {
                    Service.class.wait();
                } catch (InterruptedException e) {
                    LOGGER.error("synchronized error",e);
                }
            }
        }
    }
}
