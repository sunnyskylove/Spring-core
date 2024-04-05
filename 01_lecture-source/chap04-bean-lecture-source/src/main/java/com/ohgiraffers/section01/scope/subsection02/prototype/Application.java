package com.ohgiraffers.section01.scope.subsection02.prototype;

import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);     // 자바 방식

        String[] beanNames = context.getBeanDefinitionNames();
        for(String bean : beanNames) {
            System.out.println("bean = " + bean);       // bean = carpBread, milk,water,cart 차례로 다 나온다
        }

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("carpBread", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        cart1.addItem(cartBread);
        cart1.addItem(milk);
        System.out.println("cart1 가지고 있는 상품들 : " + cart1.getItems());       // 정보 상세히 나옴

        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);
        System.out.println("cart2 가지고 있는 상품들 : " + cart2.getItems());


        // 해쉬코드도 출력해 보기~~ (주소값!!)
        System.out.println("cart1의 hashcode : " + cart1.hashCode());
        System.out.println("cart2의 hashcode : " + cart2.hashCode());
        // 확인 : cart1,cart2 주소값 다르다!! / 상품도 다르다.
    }
}



}
