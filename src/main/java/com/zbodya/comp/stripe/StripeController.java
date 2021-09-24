package com.zbodya.comp.stripe;

import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Invoice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/stripeApi")
public class StripeController
{
    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @GetMapping("/createInvoice")
    public ResponseEntity<String> createInvoice(@RequestParam("customerID")String customerID)
    {
        Stripe.apiKey = stripePublicKey;
        Map<String,Object> params = new HashMap<>();
        params.put("customer",customerID);
        try {
            Invoice invoice = Invoice.create(params);
        } catch (AuthenticationException | InvalidRequestException | APIConnectionException | CardException | APIException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Invoice was created!",HttpStatus.OK);
    }

    @GetMapping("/retrieveInvoice")
    public ResponseEntity<String> retrieveInvoice(@RequestParam("invoiceID")String invoiceID)
    {
        Stripe.apiKey = stripePublicKey;
        Invoice invoice;
        try {
            invoice = Invoice.retrieve(invoiceID);
        } catch (AuthenticationException | InvalidRequestException | APIConnectionException | CardException | APIException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(invoice.getDescription(),HttpStatus.OK);
    }


}
