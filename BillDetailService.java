package com.bill.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bill.adapter.BillDetailAdapter;
import com.bill.dto.BillDetailDto;
import com.bill.model.BillDetail;
import com.bill.repository.BillDetailRepository;

@Service
public class BillDetailService {

	private final BillDetailAdapter billDetailAdapter;
	
	private final BillDetailRepository billDetailRepository;
	
	public BillDetailService(BillDetailAdapter billDetailAdapter,BillDetailRepository billDetailRepository)
	{
		this.billDetailAdapter=billDetailAdapter;
		this.billDetailRepository=billDetailRepository;
	}
	
	public List<BillDetailDto> getListBills()
	{
		List<BillDetail> bill=billDetailRepository.findAll();
		for(BillDetail bd:bill)
		{
			System.out.println(bd);
		}
		return billDetailAdapter.getBillDetailDtos(billDetailRepository.findAll());
	}
	
	public BillDetailDto getBill(String billNumber)
	{
		return billDetailAdapter.getBillDetailDto(billDetailRepository.getById(billNumber));
	}
	
	public List<BillDetailDto> billDueDate(LocalDate billedDate)
	{
		return billDetailAdapter.getBillDetailDtos(billDetailRepository.findByBilledDate(billedDate));
	}
}
