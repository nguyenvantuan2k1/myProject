package com.example.backend.reponsitory;

import com.example.backend.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository  extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);

//    Page<Account> findByAdmin(Boolean admin, Pageable pageable);
}
