import models.Book;
import models.Borrower;
import models.Library;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    Library library;
    Borrower borrower1;
    Borrower borrower2;
    Book book1;
    Book book2;
    Book book3;
    Book book4;

    @Before
    public void setUp() {
        library = new Library("Dragons Book Emporium");
        borrower1 = new Borrower("Berto", library);
        borrower2 = new Borrower("Elton John", library);
        book1 = new Book("Lord ae the rings", library);
        book2 = new Book("Hairy Potter", library);
        book3 = new Book("Fire-Breathing 101", library);
        book4 = new Book("Jackie Chan goes to Jeruselem", library);
    }

    @Test
    public void libraryHasName() {
        assertEquals("Dragons Book Emporium", library.getName());
    }
}
