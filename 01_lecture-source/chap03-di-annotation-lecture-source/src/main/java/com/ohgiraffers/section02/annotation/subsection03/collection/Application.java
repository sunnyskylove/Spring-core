package com.ohgiraffers.section02.annotation.subsection03.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        String[] beanNames = context.getBeanDefinitionNames();   // 등록된 Bean 이 어떤게 있는지 체크해보기!

        for(String bean : beanNames) {
            System.out.println(bean);
        }

        AnimalService animalService = context.getBean("animalCollection", AnimalService.class);

        animalService.animalEat();  // collection에다가 animal을 가둔것! 코알라~호랑이의 출력본이 나온다.

    }

}