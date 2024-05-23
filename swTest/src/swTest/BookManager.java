package swTest;

import java.util.HashMap;
import java.util.Map;

public class BookManager {
    private Map<Integer, Book> books = new HashMap<>();

    public boolean addBook(Book book) {
        if (books.containsKey(book.getId())) {
            System.out.println("해당 ID(" + book.getId() + ")는 이미 존재합니다.");
            return false;
        }
        books.put(book.getId(), book);
        System.out.println(book + " 도서가 추가되었습니다.");
        return true;
    }

    public boolean removeBook(int id) {
        if (!books.containsKey(id)) {
            System.out.println("해당 ID(" + id + ")의 도서를 찾을 수 없습니다.");
            return false;
        }
        Book removedBook = books.remove(id);
        System.out.println(removedBook + " 도서를 삭제하였습니다.");
        return true;
    }

    public Book searchBook(String title) {
        for (Book book : books.values()) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        System.out.println("검색된 도서가 없습니다.");
        return null;
    }
}