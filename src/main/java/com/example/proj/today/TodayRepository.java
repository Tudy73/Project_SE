package com.example.proj.today;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodayRepository
        extends JpaRepository<Today,Long> {

}
