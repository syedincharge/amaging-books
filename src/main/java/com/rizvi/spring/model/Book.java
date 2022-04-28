package com.rizvi.spring.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


@Data
@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
@Table(name="books")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String isbn;

    private String title;

    private String publishedDate;

    private Integer issuedCopies;

    private Integer totalCopies;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Author author;


    @JsonCreator
    public Book(@JsonProperty("bookId")  Long bookId, @JsonProperty("isbn")  String isbn, @JsonProperty("title")  String title, @JsonProperty("publishedDate")   String publishedDate, @JsonProperty("issuedCopies")  Integer issuedCopies, @JsonProperty("totalCopies") Integer totalCopies,  @JsonProperty("author") Author author) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.publishedDate = publishedDate;
        this.issuedCopies = issuedCopies;
        this.totalCopies = totalCopies;
        this.author = author;
    }
}