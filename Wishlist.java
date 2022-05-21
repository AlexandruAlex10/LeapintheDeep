package com.example.bwa.user;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table
public class Wishlist {
    @Id
    @SequenceGenerator(
            name = "w_sequence",
            sequenceName = "w_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "w_sequence"
    )
    @Column(nullable = false, updatable = false) //WE DON'T SEND id AT POST REQUEST: id - GENERATED BY @GeneratedValue
    private @NotBlank Long wId;
    @OneToOne(mappedBy = "wishlist")
    private User user;
    @OneToMany(mappedBy = "wishlist", cascade = CascadeType.ALL)
    private List<Book> books;
}
