package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        
        /* 필기.
        *   @Autowired
        *   의존성을 주입할 때 사용되는 대표적인 어노테이션이다.
        *   의존성을 주입하는 방법은 3가지 방법이 있다.
        *   1. 필드 주입    - 20% 정도 사용
        *   2. 생성자 주입   - 80% 정도 사용 (주로 쓰임)
        *   3. setter 주입 - 거의 사용 x
        * */

        ApplicationContext context = 
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01");
        // section01아래에 있는거 까지 스캔하겠다..????
        
        BookService service = context.getBean("ServiceField",BookService.class);
                
        /* 전체 도서목록 조회하기 */
        List<BookDTO> books = service.selectAllBooks();
        for(BookDTO book: books) {
            System.out.println("book = " + book);
        }
        
    }
}
