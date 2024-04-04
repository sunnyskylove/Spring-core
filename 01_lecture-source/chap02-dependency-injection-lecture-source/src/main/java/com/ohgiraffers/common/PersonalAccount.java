package com.ohgiraffers.common;

import lombok.ToString;

@ToString              // annotation 달아주기
public class PersonalAccount implements Account{              // 구현 강제화된 메소드 소환~~(3개 다)

    private final int bankCode; // 은행코드
    private final String accNo; // 계좌번호
    private int balance;        // 잔액(계속 변동되므로 final 키워드 안붙임!)


    public PersonalAccount(int bankCode, String accNo) {
        this.bankCode = bankCode;
        this.accNo = accNo;
    }

    @Override
    public String getBalance() {
        return this.accNo + "계좌의 현재 잔액은 " + this.balance + "원 입니다.";
    }

    @Override
    public String deposit(int money) {

        String str = "";                                // return 값이 스트링이니 "빈" 만들어준다.(초기화)

        if(money >= 0) {
            this.balance += money;                     // 입금후, 확인위해~~??

            str = money + "원이 입금되었습니다!!";         // 0보다 클 경우
        } else {
            str = "금액을 잘못 입력하셨습니다!!";           //0 보다 작을 경우
        }

        return str;
    }

    @Override
    public String withDraw(int money) {

        String str = "";

        if(this.balance >= money) {                          // 가지고 있는 돈보다 작은 걸 출금하려고 할때 가능!
            this.balance -= money;                         // 잔고에서 출금하려고 하는 돈을 빼준다.
            str = money + "원이 출금되었습니다.";             // 얼마 출금했는지도 알수 있게 만든다~

        } else {

            str = "잔액이 부족합니다. 잔액을 확인해주십쇼.";
        }

        return str;
    }
}