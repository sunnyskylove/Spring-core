package com.ohgiraffers.section01.autowired.subsection02.constructor;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ServiceConstructor")
public class BookService {

    /* 필기.
    *   1. 필드 주입은 의존성이 있는 객체가 생성되지 않아도 객체의 생성이 가능하다.
    *       따라서 메소드가 호출 될 때(런타임) 오류가 발생하게 된다.
    *       생성자 주입은 의존성이 있는 객체가 생성되지 않으면
    *       객체의 생성이 불가능하여 어플리케이션 실행 시점에 오류가 발생한다.(오류의 시점을 앞당긴다~~)
    *   2. 필드에 final 키워드를 사용할 수 있기 때문에 객체의 생성 이후
    *       의존성을 변경할 수 없어 안정성이 보장된다.
    *   3. 코드의 가독성이 좋다.
    * */


    // new 대신 autowired를 불러온다.
    // 원랜 밑 private 위에다가 붙이는데, 여기선 생성자 위에다가 붙인다!!
    // 생성자를 통한 초기화 / 따라서 final도 붙일 수 있다. 즉, 객체에 대한 안정성이 보장된다.
    @Autowired
    private final BookDAO bookDAO;        // 여기도 똑가팅 BookDAO 를 불러온다.

    public BookService(BookDAO bookDAO) {           // 만약 DAO 가 문제가 있다면 오류

        this.bookDAO = bookDAO;

    }

    public List<BookDTO> selectAllBookes(){

        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence) {

        return bookDAO.selectOneBook(sequence);
    }
}
