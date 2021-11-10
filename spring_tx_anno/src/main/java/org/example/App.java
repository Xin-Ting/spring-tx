package org.example;

import org.example.config.AopConfig;
import org.example.service.BankService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 85217
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        BankService bean = applicationContext.getBean(BankService.class);
        bean.takeMoney(1,100);
    }

}
