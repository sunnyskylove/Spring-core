package com.ohgiraffers.section02.annotation.section02.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary        // 코알라 말고, 너구리도 Primary 를 지정하면, 오류됨! (하나 이상 설정할 수 없어서)
public class Raccoon implements Animal{
    @Override
    public void eat() {
        System.out.println("너구리가 돈까스덮밥을 먹어요");
    }

}
