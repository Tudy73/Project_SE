package com.example.proj.weekly;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WeeklyRepository
        extends JpaRepository<Weekly,Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Weekly m WHERE m.text = ?1 AND m.day = ?2")
    void deleteByExceptId(String text, String day);

}
