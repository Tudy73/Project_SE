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
        System.out.println("am ajuns aici");
        for(Today today : todayList){
            System.out.println(today.toString());
            todayRepository.deleteByExceptId(today.getImage(),today.getText(),today.getHour());
        }
    }
    public void addToday(Today today){
        todayRepository.save(today);
    }
}
