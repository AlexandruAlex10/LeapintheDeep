package com.example.bwa.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "review")
public class Review {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    @Column(nullable = false, updatable = false) //WE DON'T SEND id AT POST REQUEST: id - GENERATED BY @GeneratedValue
    private Long reviewId;
    private Integer rating;
    private String comment;
    private String author;
    @ManyToOne
    @JoinColumn(name = "book_id"/*, referencedColumnName = "reviewId"*/)
    @JsonIgnore
    private Book book;
}
