package com.example.backend.reponsitory;

import com.example.backend.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository  extends JpaRepository<Account, Integer> {
    Optional<Account> findByUsername(String username);

    @Query(nativeQuery = true, value = "select * from account_roles \n" +
            "inner join `account` on `account`.id = account_roles.account_id\n" +
            "inner join `roles` on `roles`.id = account_roles.role_id\n" +
            "where roles.name = 'ROLE_ADMIN' ")
    List<Account> findByAccountRoleAdmin();
//    Page<Account> findByAdmin(Boolean admin, Pageable pageable);
}
