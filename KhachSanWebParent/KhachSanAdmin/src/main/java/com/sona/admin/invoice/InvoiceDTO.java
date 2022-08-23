package com.sona.admin.invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDTO {
    private Integer IdHD;
    private String FullName;
    private Date CreatedDate;
    private int Payment;
    private Float vat;
    private Double TienPhong;
    private Double TienDV;
    private Double TongTien;
}
