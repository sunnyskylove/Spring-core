package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration              // 설정 정보야~라고 알려줌
public class ContextConfiguration {

    @Bean
    public Account account() {          // id를 따로 설정하지 않았다면 메소드의 이름이 Id 임

        return new PersonalAccount(10,"123-12345-12341234");

    }

    @Bean
    public MemberDTO member() {

        /* 생성자를 통한 주입 */
//        return new MemberDTO(1,"조평훈","010-5518-2290","email",account());    // account 다시 부른 이유는, 그 안에 personalAccount 있어서 불러오려구 입력! 따라서 account도 그때 같이 생성됨

        /* setter 통한 주입 */
        MemberDTO member = new MemberDTO();
        member.setSequence(1);
        member.setName("조평훈");
        member.setPhone("010");
        member.setEmail("123");
        member.setPersonalAccount(account());       // account 반환값 다시 넣어준다!, 한명 회원에 대한 계좌정보 들어가게 됨!

        return member;

    }

}
