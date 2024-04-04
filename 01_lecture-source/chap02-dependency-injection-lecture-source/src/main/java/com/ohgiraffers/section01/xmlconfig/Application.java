package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        // 스프링 컨텍스트를 생성하고, XML 파일에서 빈(bean) 구성을 로드한다.
        // 이때, XML 파일의 경로를 인자로 전달한다.
        ApplicationContext context =
                new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

        // 스프링 컨텍스트에서 MemberDTO 타입의 빈을 가져와 member 변수에 할당한다.
        MemberDTO member = context.getBean(MemberDTO.class);

//        System.out.println("member = " + member);    확인

        // 실행할 요소들
        System.out.println(member.getPersonalAccount());
        System.out.println(member.getPersonalAccount().deposit(10000));     // 만원 입금!
        System.out.println(member.getPersonalAccount().getBalance());             // 잔액 확인
        System.out.println(member.getPersonalAccount().withDraw(5000));         //5천원 출금

        System.out.println(member.getPersonalAccount().withDraw(20000));   //오버되는 금액 출금 시도시, 잔액부족으로 잔액확인 출력
    }
}