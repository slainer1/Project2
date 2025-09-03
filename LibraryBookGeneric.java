package assign02;

import java.util.GregorianCalendar;

public class LibraryBookGeneric<T> extends Book
{
    private T patronNumber;
    private GregorianCalendar dueDate;

    public LibraryBookGeneric (long isbn, String authorSurname, String authorOtherName, String title)
    {
        super(isbn, authorSurname, authorOtherName, title);
        this.patronNumber = null;
        this.dueDate = null;
    }

    public T getPatron()
    {
        return patronNumber;
    }

    public GregorianCalendar getDueDate()
    {
        return this.dueDate;

    }

    public void checkOut(T patronNumber, GregorianCalendar due)
    {
        this.patronNumber = patronNumber;
        this.dueDate = due;
    }

    public void checkIn()
    {
        this.patronNumber = null;
        this.dueDate = null;
    }
}
