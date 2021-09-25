package com.zbodya.comp.stripe;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class InvoiceValidator
{
    public boolean validateID(String customerid)
    {
        return customerid !=null && !customerid.isBlank();
    }
}
