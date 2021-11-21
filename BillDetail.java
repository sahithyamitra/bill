package com.bill.model;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="BillDetail")
public class BillDetail {

	@Id
	@Column(length=34,nullable=false)
	private String billNumber;
	
	@Column(length=30,nullable=true)
	private String billedTo;
	
	private LocalDate billedDate;
	
	@Column(columnDefinition="DECIMAL",nullable=true)
	private Double billedPrice;
	
	@Column(columnDefinition="DECIMAL",nullable=true)
	private Double billedTax;
	
	@Column(columnDefinition="DECIMAL",nullable=true)
	private Double totalPrice;
}
