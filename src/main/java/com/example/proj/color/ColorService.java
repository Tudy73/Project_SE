package com.example.proj.color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {
    private final ColorRepository colorRepository;

    @Autowired
    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    public void addColor(Color color) {
        colorRepository.save(color);
    }

    public List<Color> getColorList() {
        return colorRepository.findAll();
    }
}
