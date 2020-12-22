package ru.geekbrains.hibernate.app2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Service service = context.getBean("service", Service.class);
        System.out.println(service.getBuyersByProduct(5L));
        System.out.println(service.getProductsByBuyer(4L));
    }
}
