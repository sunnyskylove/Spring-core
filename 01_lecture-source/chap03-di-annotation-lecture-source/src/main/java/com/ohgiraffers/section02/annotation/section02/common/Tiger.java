package com.ohgiraffers.section02.annotation.section02.common;

import org.springframework.stereotype.Component;

@Component
public class Tiger implements Animal {

    @Override
    public void eat() {
        System.out.println("호랑이가 어흥~거려요");

    }

}
