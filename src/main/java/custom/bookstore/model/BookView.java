package custom.bookstore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "book_view")
public class BookView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(name = "book_id")
    private Long bookId;

    @Getter
    @Setter
    @Column(name = "username")
    private String username;
}
