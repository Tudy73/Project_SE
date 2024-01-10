package com.example.proj.color;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
public class Color {
    @Id
    @SequenceGenerator(
            name ="today_sequence",
            sequenceName ="today_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "today_sequence"
    )
    private Long id;
    private String nrDay;
    private String color;

    public Color() {
    }

}
