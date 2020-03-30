package entities;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BOOK_EXAMPLE")
public class BookExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_EXAMPLE_ID")
    private Long bookExampleId;

    @Column(name = "PUBLISHING_YEAR", nullable = false)
    private Integer pubslishingYear;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "bookExample")
    private Set<Usage> userActions;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinTable(name = "BOOK_EXAMPLE_BOOK", joinColumns = @JoinColumn(name = "BOOK_EXAMPLE_ID"), inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
    private Book book;

    public String toString() {
        return "The book example published in " + pubslishingYear;
    }
}
