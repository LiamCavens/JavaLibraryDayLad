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

        Borrower borrower1 = new Borrower("Shrek", library1);
        Borrower borrower2 = new Borrower("George", library1);
        Borrower borrower3 = new Borrower("Elton John", library2);
        Borrower borrower4 = new Borrower("Pavaroti", library2);

        Book book1 = new Book("Fire-Breathing 101", library1);
        Book book2 = new Book("How to breed a dragon", library1);
        Book book3 = new Book("Harp is not a string instrument", library2);
        Book book4 = new Book("Yaldi, I Love Aldi", library2);

        DBHelper.saveOrUpdate(library1);
        DBHelper.saveOrUpdate(library2);
        DBHelper.saveOrUpdate(borrower1);
        DBHelper.saveOrUpdate(borrower2);
        DBHelper.saveOrUpdate(borrower3);
        DBHelper.saveOrUpdate(borrower4);
        DBHelper.saveOrUpdate(book1);
        DBHelper.saveOrUpdate(book2);
        DBHelper.saveOrUpdate(book3);
        DBHelper.saveOrUpdate(book4);

    }
}
