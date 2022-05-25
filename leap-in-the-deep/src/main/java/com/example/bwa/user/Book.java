package com.example.bwa.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "book")
public class Book {
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
    private Long bookId;
    private String name;
    private String author;
    private String content;
    @ManyToMany(mappedBy = "readBooks")
    @JsonIgnore
    private List<User> users;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> reviews;

    public Integer getReviewCalculated(){
        int n = 0;
        int sum = 0;
        if (this.reviews != null) {
            for(Review r: this.reviews){
                n++;
                sum += r.getRating();
            }
            return (n != 0) ? (sum/n) : 0;
        }
        return 0;
    }

    public void addReview(Review review){
        this.reviews.add(review);
    }
}
