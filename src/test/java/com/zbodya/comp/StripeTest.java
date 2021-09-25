package com.zbodya.comp;

import com.zbodya.comp.stripe.InvoiceController;
import com.zbodya.comp.stripe.InvoiceValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InvoiceController.class)
public class StripeTest
{
    @Autowired
    MockMvc mockMvc;

    @MockBean
    InvoiceValidator invoiceValidator;

    @Test
    public void createInvoice() throws Exception
    {
        when(invoiceValidator.validateID(anyString())).thenReturn(true);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get("/invoices/createInvoice")
                        .param("customerID","cus_8epDebVEl8Bs2V"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
        assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo("Your request data are invalid!");
    }

    @Test
    public void retrieveInvoice() throws Exception
    {
        when(invoiceValidator.validateID(anyString())).thenReturn(true);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get("/invoices/retrieveInvoice")
                        .param("invoiceID","in_1Jb8L22eZvKYlo2CblukLzIX"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
        assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo("Your request data are invalid!");
    }
}
