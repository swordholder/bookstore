package custom.bookstore.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "details")
    private String details;

    @Getter
    @Setter
    @Column(name = "price")
    private double price;

    @Getter
    @Setter
    @Column(name = "image")
    private String image;

    @Override
    public String toString(){
        return "Name: " + name + ", Price: " + price + " Details: " + details + " Image: " + image;
    }
}
