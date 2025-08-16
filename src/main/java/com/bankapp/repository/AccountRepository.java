package com.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.entity.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

	AccountEntity findByAccountNo(String accountNo);

}
