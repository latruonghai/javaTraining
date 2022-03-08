package com.lth.demoBeans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApp {

    public static void main(String[] args){
        ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
        BeanFactory beanFactory = (BeanFactory) app;

        Office office = (Office)beanFactory.getBean("officeBean");

        office.getDeveloper().work();
        office.getTester().work();
    }
}
