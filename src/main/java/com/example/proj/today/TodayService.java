package com.example.proj.today;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodayService {

    private final TodayRepository todayRepository;

    @Autowired
    public TodayService(TodayRepository todayRepository) {
        this.todayRepository = todayRepository;
    }
    public List<Today> getTodayDataByAccountId() {
        return todayRepository.findAll();
    }

    public void saveData(List<Today> todayList) {
        todayRepository.saveAll(todayList);
    }

    public void deleteData(List<Today> todayList) {
        todayRepository.deleteAll();
    }

//    public ResponseEntity<List<Today>> getTodayDataByAccountId() {
//        List<Today> todayData =c.getTodayData();
//        List<Today> weeklyData =c.getTodayDataFromWeekly(dayOfWeek);
//        todayData.addAll(weeklyData);
//        List<Today> monthlyData =c.getTodayDataFromMonthly(dayOfMonth);
//        todayData.addAll(monthlyData);
//        return ResponseEntity.ok(todayData);
//    }
}
