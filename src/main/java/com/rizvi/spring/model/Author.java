package com.rizvi.spring.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String isbn;


    @JsonCreator
    public Author(@JsonProperty("id") Long id, @JsonProperty("name") String name, @JsonProperty("isbn") String isbn) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;

    }
}
