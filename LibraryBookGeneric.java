package assign02;

import java.util.GregorianCalendar;

public class LibraryBookGeneric<Type> extends Book
{
    private Type patronNumber;
    private GregorianCalendar dueDate;

    public LibraryBookGeneric (long isbn, String authorSurname, String authorOtherName, String title)
    {
        super(isbn, authorSurname, authorOtherName, title);
        this.patronNumber = null;
        this.dueDate = null;
    }

    public Type getPatron()
    {
        return patronNumber;
    }

    public GregorianCalendar getDueDate()
    {
        return dueDate;

    }

    public void checkOut(Type patronNumber, GregorianCalendar due)
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
