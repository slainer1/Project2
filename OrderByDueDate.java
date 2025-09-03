package assign02;

import java.util.Calendar;
import java.util.Comparator;

public class OrderByDueDate<T> implements Comparator<LibraryBookGeneric<T>> {
    @Override
    public int compare(LibraryBookGeneric<T> firstBook, LibraryBookGeneric<T> secondBook) {
        if (firstBook.getDueDate().get(Calendar.DATE) > secondBook.getDueDate().get(Calendar.DATE)){
            return 1;
        }
        if (firstBook.getDueDate().get(Calendar.DATE) < secondBook.getDueDate().get(Calendar.DATE)){
            return -1;
        }
        return 0;
    }
}
