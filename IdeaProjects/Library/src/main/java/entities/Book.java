package entities;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    private Long bookId;

    @Column(name = "BOOK_NAME", nullable = false, length = 100)
    private String name;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "book")
    private Set<BookExample> bookExamples;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinTable(name = "BOOK_AUTHOR", joinColumns = @JoinColumn(name = "BOOK_ID"), inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
    private Author author;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "BOOK_COAUTHOR", joinColumns = {
            @JoinColumn(name = "BOOK_ID", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "AUTHOR_ID", nullable = false, updatable = false)})
    private Set<Author> coauthors;

    public String toString() {
        return "The book " + name + " written by " + author;
    }
}
