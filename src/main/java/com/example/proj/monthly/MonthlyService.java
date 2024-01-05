package com.example.proj.monthly;

import com.example.proj.today.Today;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MonthlyService {
    private final MonthlyRepository monthlyRepository;
    @Autowired
    public MonthlyService(MonthlyRepository monthlyRepository) {
        this.monthlyRepository = monthlyRepository;
    }

    public void saveMonthly(List<Monthly> monthlyList) {
        monthlyRepository.saveAll(monthlyList);
    }

    public List<Today> getMonthlyData(int number) {
        Optional<List<Monthly>> todayByNumber = monthlyRepository.findTodayByNumber(number);
        List<Today> todayList = new ArrayList<>();
        if(todayByNumber.isPresent()){
            for(Monthly monthly : todayByNumber.get()){
                todayList.add(new Today(monthly.getId(), monthly.getImage(), monthly.getText(), monthly.getHour()));
            }
        }
        return todayList;
    }

    public void deleteMonthly(List<Monthly> monthlyList) {
        for(Monthly monthly : monthlyList){
            monthlyRepository.deleteMonthly(monthly.getText(), monthly.getHour(),monthly.getNrDay());
        }
    }
}
