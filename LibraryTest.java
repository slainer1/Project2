package assign02;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Test class containing some example tests for Library.
 *
 * Students are expected to add additional tests to this class to thoroughly 
 * check the correctness of Library.
 * 
 * @author CS 2420 course staff && ??
 * @version 2025-08-28
 */
public class LibraryTest {

	private Library emptyLibrary, tinyLibrary, smallLibrary;
	
	@BeforeEach
	void setUp() throws Exception {
		emptyLibrary = new Library();
		tinyLibrary = new Library();
		tinyLibrary.add(9780374292799L, "Friedman", "Thomas L.", "The World is Flat");
		tinyLibrary.add(9780330351690L, "Krakauer", "Jon", "Into the Wild");
		tinyLibrary.add(9780446580342L, "Baldacci", "David", "Simple Genius");
		tinyLibrary.add(9781843193319L,	"Akers", "Alan Burt","Transit to Scorpio");
		smallLibrary = new Library();
		smallLibrary.addAll("/Users/slainer/Downloads/assign02/Mushroom_Publishing.txt");
	}

	@Test
	public void testEmptyLookupISBN() {
		assertEquals(-1, emptyLibrary.lookup(978037429279L));
	}
	
	@Test
	public void testEmptyLookupPatron() {
		ArrayList<LibraryBook> booksCheckedOut = emptyLibrary.lookup(123);
		assertNotNull(booksCheckedOut);
		assertEquals(0, booksCheckedOut.size());
	}
	
	@Test
	public void testEmptyCheckOut() {
		assertFalse(emptyLibrary.checkOut(978037429279L, 123, 10, 1, 2024));
	}

	@Test
	public void testEmptyCheckInISBN() {
		assertFalse(emptyLibrary.checkIn(978037429279L));
	}
	
	@Test
	public void testEmptyCheckInPatron() {
		assertFalse(emptyLibrary.checkIn(123));
	}

	@Test
	public void testTinyLibraryLookupISBN() {
		assertEquals(-1, tinyLibrary.lookup(9780330351690L));
	}
	
	@Test
	public void testTinyLibraryLookupPatron() {
		tinyLibrary.checkOut(9780330351690L, 123, 10, 1, 2024);
		ArrayList<LibraryBook> booksCheckedOut = tinyLibrary.lookup(123);
		
		assertNotNull(booksCheckedOut);
		assertEquals(1, booksCheckedOut.size());
		assertEquals(new Book(9780330351690L, "Krakauer", "Jon", "Into the Wild"), booksCheckedOut.get(0));
		assertEquals(123, booksCheckedOut.get(0).getPatron());
	}

	@Test
	public void testTinyLibraryCheckOut() {
		assertTrue(tinyLibrary.checkOut(9780330351690L, 123, 10, 1, 2024));
	}

	@Test
	public void testTinyLibraryCheckInISBN() {
		tinyLibrary.checkOut(9780330351690L, 123, 10, 1, 2024);
		assertTrue(tinyLibrary.checkIn(9780330351690L));
	}

	@Test
	public void testTinyLibraryCheckInPatron() {
		assertFalse(tinyLibrary.checkIn(123));
	}
	
	@Test
	public void testTinyLibraryMultiCheckout(){
		assertTrue(tinyLibrary.checkOut(9780330351690L, 123, 10, 1, 2024));
		assertTrue(tinyLibrary.checkOut(9781843193319L, 123, 10, 1, 2024));
	}
	@Test
	public void testTinyLibraryMultiLookup(){
		tinyLibrary.checkOut(9780330351690L, 123, 10, 1, 2024);
		tinyLibrary.checkOut(9781843193319L, 123, 10, 1, 2024);
		ArrayList<LibraryBook> booksCheckedOut = tinyLibrary.lookup(123);

		assertNotNull(booksCheckedOut);
		assertEquals(2, booksCheckedOut.size());
		assertEquals(new Book(9781843193319L,	"Akers", "Alan Burt","Transit to Scorpio"), booksCheckedOut.get(1));
		assertEquals(new Book(9780330351690L, "Krakauer", "Jon", "Into the Wild"), booksCheckedOut.get(0));

		assertEquals(123, booksCheckedOut.get(0).getPatron());
	}
}
