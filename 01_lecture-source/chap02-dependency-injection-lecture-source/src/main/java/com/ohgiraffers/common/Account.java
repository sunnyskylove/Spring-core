package com.ohgiraffers.common;

public interface Account {

    /* 문. 잔액 조회 */
    String getBalance();

    /* 문. 입금 */
    String deposit(int money);

    /* 문. 출금 */
    String withDraw(int money);

}
