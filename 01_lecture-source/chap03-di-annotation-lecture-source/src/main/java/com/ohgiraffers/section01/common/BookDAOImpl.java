package com.ohgiraffers.section01.common;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

// BookDAO를 상속받았다고 하여 제목을 BookDAOImpl 라고 함(실제로도 이렇게 쓰인다고 한다.)
//@Component
/* 중요. @Component 의 세분화 어노테이션의 한 종류로 DAO 타입의 객체에 사용 */
@Repository("bookDAO")      // database를 연결하고 있는 저장소로 지정!!

public class BookDAOImpl implements BookDAO{
    // 상속받고, 이젠 Bean 객체로 등록하려고 함! 그리고 먼저, 도서에 대한 정보 2개를 미리 만듦!

    private final Map<Integer, BookDTO> bookList;

    public BookDAOImpl() {
        bookList = new HashMap<>();
        bookList.put(1, new BookDTO(1, 123456, "혼자공부하는자바", "조평훈", "한빛출판", new Date())); //Map에다가 미리 값들을 넣음()
        bookList.put(2, new BookDTO(2, 654321, "혼자공부하는자바2", "조훈평", "두빛출판", new Date()));
    }

    @Override
    public List<BookDTO> selectBookList() {

        return new ArrayList<>(bookList.values());
    }

    @Override
    public BookDTO selectOneBook(int sequence) {
        return bookList.get(sequence);
    }
}