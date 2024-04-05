package com.ohgiraffers.section02.annotation.section02.subsection01.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println(beanName);

        }

        AnimalService animalService = context.getBean("animalPrimary", AnimalService.class);

        animalService.animalEat();     // 코알라가 쿨쿨~ 잠만자요 가 출력!!(코알라에 해당하는 출력문이 나옴)
    }

}
