package com.bill.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bill.model.BillDetail;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail,String>{

	@Query(value="From BillDetail where billedDate=?1",nativeQuery=true)
	public List<BillDetail> findByBilledDate(LocalDate billedDate);
}
