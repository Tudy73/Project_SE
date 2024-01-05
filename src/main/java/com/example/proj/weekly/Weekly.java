package com.example.proj.weekly;

import jakarta.persistence.*;

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

    public Long getId() {
        return id;
    }

    public Weekly(String day, String text, String image, String hour) {
        this.day = day;
        this.text = text;
        this.image = image;
        this.hour = hour;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public String getHour() {
        return hour;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
