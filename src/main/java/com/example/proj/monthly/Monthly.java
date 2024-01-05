package com.example.proj.monthly;

import jakarta.persistence.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNrDay(String nrDay) {
        this.nrDay = nrDay;
    }

    public String getNrDay() {
        return nrDay;
    }

    public String getImage() {
        return image;
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

    @Override
    public String toString() {
        return "Monthly{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", text='" + text + '\'' +
                ", hour='" + hour + '\'' +
                ", nrDay='" + nrDay + '\'' +
                '}';
    }
}
