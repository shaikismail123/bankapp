package com.bankapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bankapp.entity.TransactionEntity;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {



	@Query(value = """
			SELECT * FROM transactions t
			WHERE MONTH(t.created_time) = :month
			  AND YEAR(t.created_time) = :year
			  AND (
			      t.from_account = (SELECT a.account_id FROM accounts a WHERE a.account_no = :accountNo)
			      OR t.to_account = (SELECT a.account_id FROM accounts a WHERE a.account_no = :accountNo)
			  )
			""", nativeQuery = true)
	List<TransactionEntity> findByMonthYearAndAccountNo(@Param("month") int month, @Param("year") int year,
			@Param("accountNo") String accountNo);

}
