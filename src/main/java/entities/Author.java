package entities;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AUTHOR")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID")
    private Long authorId;

    @Column(name = "AUTHOR_FIRST_NAME", nullable = false, length = 100)
    private String firstName;

    @Column(name = "AUTHOR_LAST_NAME", nullable = false, length = 100)
    private String lastName;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "author")
    private Set<Book> booksByAuthor;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "coauthors")
    private Set<Book> booksByCoauthor;

    public String toString() {
        return firstName + " " + lastName;
    }
}
