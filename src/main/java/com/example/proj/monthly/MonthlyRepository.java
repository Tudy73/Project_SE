package com.example.proj.monthly;
import com.example.proj.today.Today;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MonthlyRepository
        extends JpaRepository<Monthly,Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Monthly m WHERE m.text = ?1 AND m.hour =?2 AND m.nrDay = ?3")
    void deleteMonthly(String text,String hour,String nrDay);


    @Query("SELECT m FROM Monthly m WHERE m.nrDay = ?1")
    Optional<List<Monthly>> findTodayByNumber(int number);

}
