import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookManagerTest {
    private BookManager manager;

    @BeforeEach
    public void setUp() {
        manager = new BookManager();
    }

    @Test
    public void testAddBook() {
        Book book1 = new Book(4, "자바 기초", "Jane", 2021);
        assertTrue(manager.addBook(book1));

        // 이미 존재하는 ID의 책을 추가하려는 경우
        Book book2 = new Book(4, "자바 기초", "Jane", 2021);
        assertFalse(manager.addBook(book2));

        // 더 많은 책 추가
        Book book3 = new Book(5, "Java Advanced", "John", 2022);
        Book book4 = new Book(6, "Python Basics", "Alice", 2020);
        Book book5 = new Book(7, "C++ Advanced", "Bob", 2019);
        Book book6 = new Book(8, "Web Development", "Carol", 2018);
        Book book7 = new Book(9, "Data Science", "Dave", 2023);
        Book book8 = new Book(10, "Machine Learning", "Eve", 2021);
        Book book9 = new Book(11, "Artificial Intelligence", "Frank", 2022);
        Book book10 = new Book(12, "Database Systems", "Grace", 2020);

        assertTrue(manager.addBook(book3));
        assertTrue(manager.addBook(book4));
        assertTrue(manager.addBook(book5));
        assertTrue(manager.addBook(book6));
        assertTrue(manager.addBook(book7));
        assertTrue(manager.addBook(book8));
        assertTrue(manager.addBook(book9));
        assertTrue(manager.addBook(book10));
    }

    @Test
    public void testRemoveBook() {
        // 책을 추가합니다.
        manager.addBook(new Book(1, "Java Programming", "Author A", 2021));
        manager.addBook(new Book(2, "Python Programming", "Author B", 2020));
        manager.addBook(new Book(3, "파이썬 기초", "Author C", 2019));

        // 책을 삭제합니다.
        assertTrue(manager.removeBook(2));

        // 삭제된 책을 검색합니다.
        Book book = manager.searchBook(2);
        assertNull(book);

        // 삭제되지 않은 책을 검증합니다.
        book = manager.searchBook(1);
        assertNotNull(book);
        assertEquals(1, book.getId());
        assertEquals("Java Programming", book.getTitle());
    }

    @Test
    public void testSearchBook() {
        // 책을 추가합니다.
        manager.addBook(new Book(1, "Java Programming", "Author A", 2021));
        manager.addBook(new Book(2, "Python Programming", "Author B", 2020));
        manager.addBook(new Book(3, "파이썬 기초", "Author C", 2019));

        // 책을 검색합니다.
        Book book = manager.searchBook(3);
        assertNotNull(book);
        assertEquals(3, book.getId());
        assertEquals("파이썬 기초", book.getTitle());

        // 검색 결과 출력
        System.out.println("검색 결과: " + book);
    }

    @Test
    public void testSearchBSFound() {
        // 책을 추가합니다.
        manager.addBook(new Book(1, "Java Programming", "Author A", 2021));
        manager.addBook(new Book(2, "Python Programming", "Author B", 2020));
        manager.addBook(new Book(3, "파이썬 기초", "Author C", 2019));

        // 이진 탐색으로 책을 검색합니다.
        Book book = manager.search_bs(3);

        // 검색된 책을 검증합니다.
        assertNotNull(book);
        assertEquals(3, book.getId());
        assertEquals("파이썬 기초", book.getTitle());

        // 검색 결과 출력
        System.out.println("검색 결과: " + book);
    }

    @Test
    public void testSearchBSNotFound() {
        // 책을 추가합니다.
        manager.addBook(new Book(1, "Java Programming", "Author A", 2021));
        manager.addBook(new Book(2, "Python Programming", "Author B", 2020));
        manager.addBook(new Book(3, "파이썬 기초", "Author C", 2019));

        // 존재하지 않는 책 ID로 검색합니다.
        Book book = manager.search_bs(13); // 테스트를 위해 존재하지 않는 ID 사용
        assertNull(book);

        // 검색 결과 출력
        System.out.println("검색 결과: " + book);
    }
    @Test
    public void testSearchPerformance() {
        // 대량의 책을 추가합니다.
        for (int i = 1; i <= 10000; i++) {
            manager.addBook(new Book(i, "Title " + i, "Author " + i, 2000 + (i % 20)));
        }

        // 검색할 책 ID 설정
        int searchId = 5000;

        // 선형 검색 성능 테스트
        long startTime = System.nanoTime();
        Book linearSearchBook = manager.searchBook(searchId);
        long endTime = System.nanoTime();
        long linearSearchTime = endTime - startTime;
        System.out.println("search 검색 시간: " + linearSearchTime + " ns");

        // 이진 탐색 성능 테스트
        startTime = System.nanoTime();
        Book binarySearchBook = manager.search_bs(searchId);
        endTime = System.nanoTime();
        long binarySearchTime = endTime - startTime;
        System.out.println("search_bs 시간: " + binarySearchTime + " ns");

        // 검색 결과 검증
        assertNotNull(linearSearchBook);
        assertEquals(searchId, linearSearchBook.getId());
        assertNotNull(binarySearchBook);
        assertEquals(searchId, binarySearchBook.getId());

        // 성능 비교 및 결과 출력
        if (linearSearchTime < binarySearchTime) {
            System.out.println("search()가 더 빠릅니다.");
        } else {
            System.out.println("search_bs()가 더 빠릅니다.");
        }
    }
}


