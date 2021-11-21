package com.bill.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
public class BillDetailDto {

	private String billNumber;
	
	private String billedTo;
	
	private LocalDate billedDate;
	
	private Double billedPrice;
	
	private Double billedTax;
	
	private Double totalPrice;
}
