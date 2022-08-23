package com.sona.admin.invoice;

import com.sona.common.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;
    public List<Invoice> listall(){
        return (List<Invoice>) invoiceRepository.findAll();
    }
    public List<InvoiceDTO> getall(){
        List<InvoiceDTO> invoiceDTOS=invoiceRepository.getall().stream().map((value)->{
            Integer IdHD=(Integer) value[0];
            String FullName=(String) value[1];
            Date CreatedDate=(Date) value[2];
            int Payment=(int) value[3];
            Float vat=(Float) value[4];
            Double TienPhong=(Double) value[5];
            Double TienDV=(Double) value[6];
            Double TongTien=(Double) value[7];
            return new InvoiceDTO(IdHD,FullName,CreatedDate,Payment,vat,TienPhong,TienDV,TongTien);
        }).collect(Collectors.toList());
        return invoiceDTOS;
    }
}
