package com.ohgiraffers.section02.initdestroy.subsection02.annotation;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Configuration
@ComponentScan("com.ohgiraffers.section02.initdestroy.subsection02.annotation")
// ▲ 호출되게 하려고 Scan @ 추가!, ()안에는 하나밖에 없으면 "문자열로 써도 되지만, 여러개이면 basePackages로~
public class ContextConfiguration {

    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new Date());
    }

    @Bean
    public Product milk() {
        return new Beverage("초코우유", 2000, 500);
    }

    @Bean
    public Product water() {
        return new Beverage("삼다수", 50000, 500);
    }


    /* 기본적인 스코프는 싱글톤!!!
     *  하나의 인스턴스만을 생성을 하고, 모든 빈이 해당 인스턴스를 공유하다.
     * */

    /* 참고. prototype : getBean() 시에 매번 새로운 인스턴스를 생성하게 해준다. */
    @Bean
    @Scope("prototype")             // prototype 이라는 문자열 전달하기
    public ShoppingCart cart() {return new ShoppingCart();



    }


}
