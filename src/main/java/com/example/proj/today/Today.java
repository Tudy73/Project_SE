package com.example.proj.today;

import jakarta.persistence.*;

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

    public String getImage() {
        return image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }


}
