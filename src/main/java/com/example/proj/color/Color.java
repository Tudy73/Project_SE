package com.example.proj.color;

import jakarta.persistence.*;

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

    public void setNrDay(String nrDay) {
        this.nrDay = nrDay;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNrDay() {
        return nrDay;
    }

    public String getColor() {
        return color;
    }
}
