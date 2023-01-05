package com.example.demo.student;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Student {
    @Id
    @jakarta.persistence.SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @jakarta.persistence.GeneratedValue(
            generator = "student_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String name;
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    @NotNull
    @jakarta.persistence.Enumerated(jakarta.persistence.EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    // Constructor withoud id
    public Student(String name, String email, Gender gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}
