package com.example.proj.Model;

public class Saptamanal {
    private String day;
    private String Text;

    public Saptamanal(String day, String text) {
        this.day = day;
        Text = text;
    }

    public String getDay() {
        return day;
    }

    public String getText() {
        return Text;
    }
}
