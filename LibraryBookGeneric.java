package assign02;

import java.util.GregorianCalendar;

public class LibraryBookGeneric<Type> extends Book {
    private int patronNumber;
    private GregorianCalendar dueDate;
    public LibraryBookGeneric(long isbn, String authorSurname, String authorOtherName, String title) {
        super(isbn, authorSurname, authorOtherName, title);
        this.patronNumber = -1;
        this.dueDate = null;

    }
    public int getPatron(){
        return patronNumber;
    }
    public GregorianCalendar getDueDate(){
        return dueDate;

    }
    public void checkOut(int patronNumber, GregorianCalendar due){
        this.patronNumber = patronNumber;
        this.dueDate = due;
    }
    public void checkIn(){
        this.patronNumber = -1;
        this.dueDate = null;
    }

}
