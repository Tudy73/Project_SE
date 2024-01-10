package com.example.proj.monthly;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Entity
@Table
public class Monthly {

    @Id
    @SequenceGenerator(
            name ="monthly_sequence",
            sequenceName ="monthly_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "monthly_sequence"
    )
    private Long id;
    private String image;
    private String text;
    private String hour;
    private String nrDay;

    public Monthly() {

    }

    public Monthly(String image, String text, String hour, String nrDay) {
        this.image = image;
        this.text = text;
        this.hour = hour;
        this.nrDay = nrDay;
    }

}
