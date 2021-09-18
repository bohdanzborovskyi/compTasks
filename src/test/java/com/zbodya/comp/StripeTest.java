package com.zbodya.comp;

import com.zbodya.comp.stripe.StripeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StripeController.class)
public class StripeTest
{
    @Autowired
    MockMvc mockMvc;

    @Test
    public void createInvoice() throws Exception
    {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get("/stripeApi/createInvoice")
                        .param("customerID","cus_8epDebVEl8Bs2V"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
        assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo("Nothing to invoice for customer");
    }

    @Test
    public void retrieveInvoice() throws Exception
    {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get("/stripeApi/retrieveInvoice")
                        .param("invoiceID","in_1Jb8L22eZvKYlo2CblukLzIX"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
        assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo("No such invoice: 'in_1Jb8L22eZvKYlo2CblukLzIX'");
    }
}
