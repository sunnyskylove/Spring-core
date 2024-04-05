package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDAOImpl;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

/* 참고. @Component 의 세분화 어노테이션으로 Service 계층에서 사용된다. */
//@Component
@Service("ServiceField")
public class BookService {

//    private BookDAO bookDAO = new BookDAOImpl();      이렇게 만들수 있지만, 직접적으로 new를 쓰지않고, 아래처럼 만들수 있다.

    /* 참고. BookDAO 타입의 Bean(객체)를 이 프로퍼티에 자동으로 주입해준다. */
    @Autowired
    private BookDAO bookDAO;

    /* 전체조회 호출 */
    public List<BookDTO> selectAllBooks() {

//      bookDAO = new BookDAOImpl();     // final 을 쓰면, 이렇게 또 다르게 만들수 있는데 그럼 오류발생되는데 찾기 어려울 수 있음..

        return bookDAO.selectBookList();
    }

    /* 번호로 책 하나 조회 */
    public BookDTO searchBookBySequence(int sequence) {

        return bookDAO.selectOneBook(sequence);

    }

}
