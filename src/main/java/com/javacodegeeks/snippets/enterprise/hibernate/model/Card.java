package com.javacodegeeks.snippets.enterprise.hibernate.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(generator ="increment")
    @GenericGenerator(name ="increment", strategy = "identity")
    @Column(name = "id", length = 11, nullable = false)
    private Integer id;

    @OneToOne
    @JoinTable(name ="Book")
    @JoinColumn(name = "id")
    @Column(name = "clientId", length = 11, nullable = false)
    private Integer clientId;

    @OneToMany
    @JoinTable(name = "client")
    @JoinColumn(name = "id")
    @Column(name = "bookId", length = 11, nullable = false)
    private Integer bookId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Override
    public String toString() {
        return "Card: " + this.id + ", " + this.clientId + ", " + this.bookId + ", " + this.date;
    }
}
