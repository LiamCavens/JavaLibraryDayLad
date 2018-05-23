package db;

import models.Book;
import models.Borrower;
import models.Library;

public class Seed {
    public static void seedDate{
        DBHelper.deleteAll(Library.class);
        DBHelper.deleteAll(Borrower.class);
        DBHelper.deleteAll(Book.class);

        Library library1 = new Library("Dragons Book Emporium");
        Library library2 = new Library("Musical Book Store");
    }
}
