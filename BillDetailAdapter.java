package com.bill.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.bill.dto.BillDetailDto;
import com.bill.model.BillDetail;

@Component
public class BillDetailAdapter {
	
	private final ModelMapper modelMapper;
	
	public BillDetailAdapter(ModelMapper modelMapper)
	{
		this.modelMapper=modelMapper;
	}
	
	public BillDetailDto getBillDetailDto(BillDetail billDetail)
	{
		return modelMapper.map(billDetail,BillDetailDto.class);
	}
	
	public List<BillDetailDto> getBillDetailDtos(List<BillDetail> billDetails)
	{
		return billDetails.stream().map(this::getBillDetailDto).collect(Collectors.toList());
	}
	
	public BillDetail getBillDetail(BillDetailDto billDetailDto)
	{
		return modelMapper.map(billDetailDto,BillDetail.class);
	}

}
