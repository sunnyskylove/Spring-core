package com.ohgiraffers.section02.initdestory.subsection01.java;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context  =
                new AnnotationConfigApplicationContext(com.ohgiraffers.section02.initdestory.subsection01.java.ContextConfiguration.class); // 자바 방식


        String[] beanNames = context.getBeanDefinitionNames();
        for(String bean : beanNames) {
            System.out.println("bean = " + bean);
        }

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);

        cart1.addItem(carpBread);
        cart1.addItem(milk);

        System.out.println("cart1 가지고 있는 상품 : " + cart1.getItem()); // 정보 상세히 나옴

        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);

        System.out.println("cart2 가지고 있는 상품 : " + cart2.getItem());

        // 해쉬코드도 출력해 보기~~ (주소값!!)
        System.out.println("cart1 의 hashcode : " + cart1.hashCode());
        System.out.println("cart2 의 hashcode : " + cart2.hashCode());
        // 확인 : cart1,cart2 주소값 다르다!! / 상품도 다르다.


        /* 필기.
         *   init 메소드는 bean 객체 생성 시점에 동작하므로 바로 확인할 수 있지만,
         *   destory 메소드는 bean 객체 소멸 시점에 동작하므로 컨테이너가 종료 되지
         *   않을 경우 확인할 수 없다.
         *   가비지 컬텍터가 해당 빈을 메모리에서 지울 때 destroy 메소드가 동작하게 되는데
         *   메모리에서 지우기 전에 프로페스는 종료되기 때문이다.
         *   따라서 close() 메소드로 컨테이너를 강제로 종료시키면 destroy 메소드가
         *   동작하게 되는 것이다.
         *  */

        // closeShop에 대한 닫아줄 메소드 만들기!!(강제로 컨테이너 종료)
        ((AnnotationConfigApplicationContext)context).close();

    }

}