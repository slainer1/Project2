package assign02;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Demonstration of how to use the non-generic LibraryBook and Library
 * classes (and does not contain tests).
 * 
 * @author CS 2420 course staff
 * @version 2025-08-28
 */
public class LibraryDemo {

	public static void main(String[] args) {

		// Create and fill in small library.
		Library textbookLibrary = new Library();
		textbookLibrary.add(9780073383095L, "Rosen", "Kenneth H.", "Discrete Mathematics and Its Applications");
		textbookLibrary.add(9780275967307L, "Stroustrup", "Bjarne", "The C++ Programming Language");
		textbookLibrary.add(9780521820608L, "Appel", "Andrew W.", "Modern Compiler Implementation in Java");
		textbookLibrary.add(9780262033848L, "Cormen", "Thomas H", "Introduction to Algorithms");
		textbookLibrary.add(9780131103627L, "Kernighan", "Brian W.", "C Programming Language");

		// Check out compilers and C books for patron with id 987, due back Sep 10.
		textbookLibrary.checkOut(9780521820608L, 987, 9, 10, 2024);
		textbookLibrary.checkOut(9780131103627L, 987, 9, 10, 2024);

		// Check out C++ book for patron with id 654, due back Sep 3.
		textbookLibrary.checkOut(9780275967307L, 654, 9, 3, 2024);

		// Check out algorithms book for patron with id 321, due back Nov 22.
		textbookLibrary.checkOut(9780262033848L, 321, 11, 22, 2024);

		for(long isbn : new long[] { 9780073383095L, 9780275967307L, 9780521820608L, 9780262033848L, 9780131103627L }) {
			System.out.print("Library book with ISBN " + isbn);
			int patronId = textbookLibrary.lookup(isbn);
			if(patronId == -1)
				System.out.println(" is not checked out.");
			else
				System.out.println(" is checked out by patron with id " + patronId + ".");
		}
		System.out.println();

		System.out.println("Patron with id 987 has these books checked out:\n"
				+ booksCheckedOutToString(textbookLibrary.lookup(987)));

		// Return compilers book
		textbookLibrary.checkIn(9780521820608L);

		System.out.println("Patron with id 987 has these books checked out:\n"
				+ booksCheckedOutToString(textbookLibrary.lookup(987)));

		// Return all books checked out by patron with id 987
		textbookLibrary.checkIn(987);

		System.out.println("Patron with id 987 has these books checked out:\n"
				+ booksCheckedOutToString(textbookLibrary.lookup(987)));
	}

	/**
	 * Generate string for list of library books, each with due date.
	 * 
	 * @param booksCheckedOut - list of library books "checked out"
	 * @return textual representation of all library books in the list
	 */
	private static String booksCheckedOutToString(ArrayList<LibraryBook> booksCheckedOut) {
		if(booksCheckedOut.size() == 0)
			return "NONE";

		String result = "";
		for(LibraryBook book : booksCheckedOut) {
			GregorianCalendar dueDate = book.getDueDate();
			result += book + " -- due back " + dueDate.get(GregorianCalendar.MONTH) + "/"
					+ dueDate.get(GregorianCalendar.DAY_OF_MONTH) + "/" + dueDate.get(GregorianCalendar.YEAR) + "\n";
		}
		return result;
	}
}
