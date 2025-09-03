package assign02;

import java.util.Comparator;

public class OrderByAuthor<T> implements Comparator<LibraryBookGeneric<T>> {
    @Override
    public int compare(LibraryBookGeneric<T> firstBook, LibraryBookGeneric<T> secondBook) {
        return firstBook.getAuthorSurname().compareTo(secondBook.getAuthorSurname());
    }
}


