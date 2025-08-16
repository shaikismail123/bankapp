package com.bankapp.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@Column(nullable = false)
	private String userName;

	@Column(unique = true)
	private String email;

	@Column
	private String mobileNo;

	@Column
	private String password;

	@Column
	private String accountType;

	@Column(updatable = false)
	@CreationTimestamp
	LocalDateTime createdTime;

	@Column(insertable = false)
	@UpdateTimestamp
	LocalDateTime updatedTime;

}
