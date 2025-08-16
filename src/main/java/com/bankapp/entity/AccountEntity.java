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

@Entity
@Table(name = "accounts")
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;

	@Column
	private String accountName;

	@Column
	private String accountNo;

	@Column
	private Double balance;

	@Column
	private String accountType;

	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdTime;

	@Column(insertable = false)
	@UpdateTimestamp
	private LocalDateTime updatedTime;

	@ManyToOne()
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;

	public AccountEntity() {
		super();
	}

	public AccountEntity(Long accountId, String accountName, String accountNo, Double balance, String accountType,
			LocalDateTime createdTime, LocalDateTime updatedTime, UserEntity userEntity) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountNo = accountNo;
		this.balance = balance;
		this.accountType = accountType;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
		this.userEntity = userEntity;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public String toString() {
		return "AccountEntity [accountId=" + accountId + ", accountName=" + accountName + ", accountNo=" + accountNo
				+ ", balance=" + balance + ", accountType=" + accountType + ", createdTime=" + createdTime
				+ ", updatedTime=" + updatedTime + ", userEntity=" + userEntity + "]";
	}

}
