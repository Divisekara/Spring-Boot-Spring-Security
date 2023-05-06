package com.example.SecurityExample.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {
    @Id // used for PK
//    @GeneratedValue(strategy = GenerationType.UUID)
    @SequenceGenerator(
            name = "student_sequence",
            allocationSize = 1,
            sequenceName = "student_sequence"
    )
    @GeneratedValue(
            generator = "student_sequence",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}

/*



 * */
