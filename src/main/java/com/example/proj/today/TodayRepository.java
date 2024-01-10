package com.example.proj.today;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodayRepository
        extends JpaRepository<Today,Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Today m WHERE m.text = ?2 AND m.hour =?3 AND m.image = ?1")
    void deleteByExceptId(String image,String text,String hour);
}
