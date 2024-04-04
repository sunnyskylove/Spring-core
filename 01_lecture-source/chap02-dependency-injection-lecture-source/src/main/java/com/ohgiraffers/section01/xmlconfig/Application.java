package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

        MemberDTO member = context.getBean(MemberDTO.class);

//        System.out.println("member = " + member);

        System.out.println(member.getPersonalAccount());
        System.out.println(member.getPersonalAccount().deposit(10000));     // 만원 입금!
        System.out.println(member.getPersonalAccount().getBalance());             // 잔액 확인

        System.out.println(member.getPersonalAccount().withDraw(20000));   //오버되는 금액 출금 시도시, 잔액부족으로 잔액확인 출력



    }

}