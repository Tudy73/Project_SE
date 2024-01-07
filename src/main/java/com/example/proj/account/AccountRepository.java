package com.example.proj.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AccountRepository
        extends JpaRepository<Account,Long> {

    @Query("SELECT a FROM Account a WHERE a.password = ?1 AND a.username = ?2")
    Optional<Account> findByAccount(String password, String username);

    Optional<Account> findByUsername(String username);
}
