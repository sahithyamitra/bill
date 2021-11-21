package com.bill.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bill.dto.BillDetailDto;
import com.bill.repository.BillDetailRepository;
import com.bill.service.BillDetailService;

@RestController
public class BillDetailController {

	private BillDetailRepository billDetailRepository;
	
	private final BillDetailService billDetailService;
	
	public BillDetailController(BillDetailRepository billDetailRepository,BillDetailService billDetailService)
	{
		this.billDetailRepository=billDetailRepository;
		this.billDetailService=billDetailService;
	}
	
	@GetMapping("/bills")
	public List<BillDetailDto> getBills()
	{
		return billDetailService.getListBills();
	}
	
	@RequestMapping(value="/bills/{billNumber}",method = RequestMethod.GET,
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public BillDetailDto getBill(@PathVariable String billNumber)
	{
		return billDetailService.getBill(billNumber);
	}
	
	@GetMapping("/bills/due/{billedDate}")
	public List<BillDetailDto> getBillDueDate(@PathVariable LocalDate billedDate)
	{
		return billDetailService.billDueDate(billedDate);
	}
	
}
