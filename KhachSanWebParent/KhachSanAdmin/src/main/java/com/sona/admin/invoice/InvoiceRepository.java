package com.sona.admin.invoice;

import com.sona.common.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    @Query(value = "CALL  `qlkhach_san`.proc_tongdichvu",nativeQuery = true)
    public List<Object[]> getall();
}
