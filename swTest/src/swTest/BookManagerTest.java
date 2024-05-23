package swTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookManagerTest {
    private BookManager manager;

    @BeforeEach
    public void setUp() {
        manager = new BookManager();
    }

    @Test
    public void testAddBook() {
        Book book1 = new Book(1, "자바 기초", "Jane", 2021);
        assertTrue(manager.addBook(book1));
        
        // 이미 존재하는 ID의 책을 추가하려는 경우
        Book book2 = new Book(1, "자바 기조", "Jane", 2021);
        assertFalse(manager.addBook(book2));
    }

    @Test
    public void testSearchBook() {
        // 도서 추가
        Book book1 = new Book(1, "자바 기초", "Jane", 2021);
        manager.addBook(book1);

        // 검색
        assertEquals(book1, manager.searchBook("자바 기초"));

        // 존재하지 않는 도서 검색
        assertNull(manager.searchBook("컴퓨터 네트워크"));
    }

    @Test
    public void testRemoveBook() {
        // 도서 추가
        Book book1 = new Book(1, "자바 기초", "Jane", 2021);
        manager.addBook(book1);

        // 도서 삭제
        assertTrue(manager.removeBook(1));

        // 존재하지 않는 도서 삭제 시도
        assertFalse(manager.removeBook(1));
    }
}

