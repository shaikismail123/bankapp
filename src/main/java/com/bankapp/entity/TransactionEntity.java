package com.bankapp.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;

	@ManyToOne
	@JoinColumn(name = "from_account", referencedColumnName = "accountId")
	private AccountEntity fromAccount;

	@ManyToOne
	@JoinColumn(name = "to_account", referencedColumnName = "accountId")
	private AccountEntity toAccount;

	@Column
	private Double amount;

	@Column
	private String descriptionType;

	@Column
	private String transactionStatus;

	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdTime;

	@Column(insertable = false)
	@UpdateTimestamp
	private LocalDateTime updatedTime;

}
