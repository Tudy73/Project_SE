package com.example.proj.today;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
public class Today {

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

    private String image;
    private String text;
    private String hour;

    public Today() {

    }

    public Today(Long id, String image, String text, String hour) {
        this.id = id;
        this.image = image;
        this.text = text;
        this.hour = hour;
    }

    public Today(String image, String text, String hour) {
        this.image = image;
        this.text = text;
        this.hour = hour;
    }


}
