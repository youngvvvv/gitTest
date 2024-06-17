import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BookManager {
    private ArrayList<Book> books;

    public BookManager() {
        books = new ArrayList<>();
    }

    public boolean addBook(Book book) {
        for (Book b : books) {
            if (b.getId() == book.getId()) {
                System.out.println("이미 존재하는 책 ID입니다: " + book.getId());
                return false; // 이미 존재하는 ID의 책은 추가하지 않음
            }
        }
        books.add(book);
        Collections.sort(books, Comparator.comparingInt(Book::getId));
        return true;
    }

    public boolean removeBook(int bookId) {
        for (Book b : books) {
            if (b.getId() == bookId) {
                books.remove(b);
                System.out.println("책을 제거했습니다: " + b);
                return true;
            }
        }
        System.out.println("책을 찾지 못했습니다.");
        return false; // 찾지 못한 경우 false 반환
    }

    public Book searchBook(int bookId) {
        for (Book b : books) {
            if (b.getId() == bookId) {
                System.out.println("책을 찾았습니다: " + b);
                return b;
            }
        }
        System.out.println("책을 찾지 못했습니다.");
        return null; // 찾지 못한 경우 null 반환
    }

    // 이진 탐색 함수 (한글 메시지 출력)
    public Book search_bs(int bookId) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);

            if (midBook.getId() == bookId) {
                System.out.println("책을 찾았습니다: " + midBook);
                return midBook;
            } else if (midBook.getId() < bookId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("책을 찾지 못했습니다.");
        return null; // 찾지 못한 경우 null 반환
    }
}
