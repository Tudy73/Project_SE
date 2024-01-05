package com.example.proj.weekly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeeklyService {
    private final WeeklyRepository weeklyRepository;

    @Autowired
    public WeeklyService(WeeklyRepository weeklyRepository) {
        this.weeklyRepository = weeklyRepository;
    }

    public void addWeeklyData(Weekly weekly) {
        weeklyRepository.save(weekly);
    }

    public List<Weekly> getWeeklyData() {
        return weeklyRepository.findAll();
    }

    public void deleteData() {
        weeklyRepository.deleteAll();
    }
}
