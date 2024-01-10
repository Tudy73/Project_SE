package com.example.proj.weekly;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Entity
@Table

public class Weekly {
    @Id
    @SequenceGenerator(
            name ="weekly_sequence",
            sequenceName ="weekly_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "weekly_sequence"
    )
    private Long id;
    private String day;
    private String text;
    private String image;
    private String hour;

    public Weekly() {

    }

    public Weekly(String day, String text, String image, String hour) {
        this.day = day;
        this.text = text;
        this.image = image;
        this.hour = hour;
    }

}
