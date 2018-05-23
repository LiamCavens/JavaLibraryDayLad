package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="borrowers")
public class Borrower  {

    private int id;
    private String name;
    private Library library;
    private Set<Book> books;

    public Borrower(String name, Library library) {
        this.name = name;
        this.library = library;
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

    @ManyToOne
    @JoinColumn(name="library_id", nullable=false)
    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @ManyToMany
    @JoinTable(name = "borrower_book",
            joinColumns = {@JoinColumn(name = "borrower_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "book_id", nullable = false, updatable = false)})
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
