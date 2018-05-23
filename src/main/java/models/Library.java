package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="libraries")
public class Library {

    private int id;
    private String name;
    private Set<Borrower> borrowers;
    private Set<Book> books;

    public Library() {
    }

    public Library(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "library")
    public Set<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(Set<Borrower> borrowers) {
        this.borrowers = borrowers;
    }

    public void addBorrower(Borrower borrower){
        this.borrowers.add(borrower);
    }

    @OneToMany(mappedBy = "library")
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void addBook(Book book){
        this.books.add(book);
    }
}
