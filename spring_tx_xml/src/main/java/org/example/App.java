package org.example;

import org.example.service.BankService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 85217
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BankService bean = applicationContext.getBean(BankService.class);
        bean.takeMoney(1,100);
    }

}
