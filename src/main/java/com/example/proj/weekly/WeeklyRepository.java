package com.example.proj.weekly;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeeklyRepository
        extends JpaRepository<Weekly,Long> {
}
