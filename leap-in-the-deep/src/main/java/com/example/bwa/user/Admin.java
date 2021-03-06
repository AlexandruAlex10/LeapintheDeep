package com.example.bwa.user;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @SequenceGenerator(
            name = "admin_sequence",
            sequenceName = "admin_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_sequence"
    )
//    @Column(nullable = false, updatable = false) //WE DON'T SEND id AT POST REQUEST: id - GENERATED BY @GeneratedValue
    private String adminCode;
    private String password;
    private Boolean logged;
}
