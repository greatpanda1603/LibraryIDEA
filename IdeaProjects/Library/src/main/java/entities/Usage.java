package entities;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LIBRARY_USAGE")
public class Usage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USAGE_ID")
    private Long usageId;

    @Column(name = "TAKE_DATE", nullable = false)
    private LocalDate takeDate;

    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinTable(name = "USER_USAGE", joinColumns = @JoinColumn(name = "USAGE_ID"), inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    private User user;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinTable(name = "BOOK_EXAMPLE_USAGE", joinColumns = @JoinColumn(name = "USAGE_ID"), inverseJoinColumns = @JoinColumn(name = "BOOK_EXAMPLE_ID"))
    private BookExample bookExample;
}
