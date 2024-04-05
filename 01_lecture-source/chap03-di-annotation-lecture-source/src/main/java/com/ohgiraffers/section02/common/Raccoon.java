package com.ohgiraffers.section02.common;

import org.springframework.stereotype.Component;

@Component
//@Primary        // 코알라 말고, 너구리도 Primary 를 지정하면, 오류됨! (하나 이상 설정할 수 없어서)
public class Raccoon implements Animal{
    @Override
    public void eat() {
        System.out.println("너구리가 폴짝폴짝 뛰어요");
    }

}
