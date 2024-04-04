package com.ohgiraffers.common;

public class PersonalAccount implements Account {       // 구현 강제화된 메소드 소환~~(3개 다)

    private final int bankCode;      // 은행코드
    private final String accNo;     // 계좌번호
    private int balance;            // 잔액(계속 변동되므로 final 키워드 안붙임!)

    public PersonalAccount(int bankCode, String accNo) {
        this.bankCode = bankCode;
        this.accNo = accNo;
    }

    @Override
    public String getBalance() {
        return null;
    }

    @Override
    public String deposit(int money) {
        return null;
    }

    @Override
    public String withDraw(int money) {
        return null;
    }
}
