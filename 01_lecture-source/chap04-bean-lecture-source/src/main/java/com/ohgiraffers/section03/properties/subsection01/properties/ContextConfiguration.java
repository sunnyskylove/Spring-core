package com.ohgiraffers.section03.properties.subsection01.properties;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
/* 참고. resources 폴더 하위에 기술한 파일을 읽어오는 annotation */
@PropertySource("section03/properties/subsection01/properties/product-info.properties")
public class ContextConfiguration {

    /* 필기.
     *   @Value
     *   ${} : 치환자(placeholder) 문법을 이용하여 properties 에 저장된
     *         key를 입력하면 value 에 해당하는 값을 꺼내올 수 있다.
     *  */

    @Value("${bread.carpbread.name}")
    private String carpBreadName;
    @Value("${bread.carpbread.price}")
    private int carpBreadPrice;
    @Value("${beverage,milk.name}")
    private String milkName;
    @Value("${beverage.milk.price}")
    private int milkPrice;
    @Value("${beverage.milk.capacity}")
    private int milkCapacity;

    @Bean
    public Product carpBread() {

        //        return new Bread("붕어빵", 3000, new Date());    //하지만 이 값들이 보이면 안되니깐..
        return new Bread(carpBreadName, carpBreadPrice, new Date());  //선언된 적이 없으므로, 위에 만들어준다!
    }

    @Bean
    public Product milk() {
        return new Beverage(milkName, milkPrice, milkCapacity);
    }

    @Bean
    public Product water(@Value("${beverage.water.name}") String waterName,
                         @Value("${beverage.water.price}") int waterPrice,
                         @Value("${bevaerage.water.capacity}") int waterCapacity) {
             return new Beverage(waterName, waterPrice, waterCapacity);
        }
    @Bean
    @Scope("prototype")
    public ShoppingCart cart() {

        return new ShoppingCart();
    }

    }
