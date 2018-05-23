package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="books")
public class Book {

    private int id;
    private String name;
    private Library library;
    private Set<Borrower> borrowers;

    public Book() {
    }

    public Book(String name, Library library) {
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "library_id", nullable = false)
    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="borrower_book",
            inverseJoinColumns = {@JoinColumn(name="borrower_id", nullable = false, updatable = false)},
            joinColumns = {@JoinColumn(name="book_id", nullable = false, updatable = false)}
    )
    public Set<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(Set<Borrower> borrowers) {
        this.borrowers = borrowers;
    }
}
