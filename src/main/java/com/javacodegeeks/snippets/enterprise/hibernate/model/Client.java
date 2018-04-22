package com.javacodegeeks.snippets.enterprise.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "identity")
    @Column(name = "id", length = 11, nullable = false)
    private Integer id;

    @Column(name = "clientId", length = 45, nullable = false)
    private String name;

    @Column(name = "bookId", length = 11, nullable = false)
    private Integer age;

    @Override
    public String toString() {
        return "Client: " + this.id + ", " + this.name + ", " + this.age;
    }
}
