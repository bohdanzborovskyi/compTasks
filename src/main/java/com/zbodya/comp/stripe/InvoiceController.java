package com.zbodya.comp.stripe;

import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/invoices")
public class InvoiceController
{

    private final InvoiceValidator validator;

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @Autowired
    public InvoiceController(InvoiceValidator validator) {
        this.validator = validator;
    }

    @GetMapping("/createInvoice")
    public ResponseEntity<String> createInvoice(@RequestParam("customerID")String customerID)
    {
        if(validator.validateID(customerID)) {
            Stripe.apiKey = stripePublicKey;
            Map<String, Object> params = new HashMap<>();
            params.put("customer", customerID);
            try {
                Invoice invoice = Invoice.create(params);
            } catch (AuthenticationException e) {
                return new ResponseEntity<>("Problem with user authentication!", HttpStatus.BAD_REQUEST);
            } catch (InvalidRequestException e) {
                return new ResponseEntity<>("Your request data are invalid!", HttpStatus.BAD_REQUEST);
            } catch (ApiConnectionException e) {
                return new ResponseEntity<>("Problem with connection to remote API! Please try later!", HttpStatus.BAD_REQUEST);
            } catch (CardException e) {
                return new ResponseEntity<>("Problem with your card! Please chat with our help center!", HttpStatus.BAD_REQUEST);
            } catch (ApiException e) {
                return new ResponseEntity<>("API doesnt work correctly! Please try later!", HttpStatus.BAD_REQUEST);
            } catch (StripeException e) {
                return new ResponseEntity<>("Global Stripe Api exception!", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Invoice was created!", HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Your request data is null or empty", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/retrieveInvoice")
    public ResponseEntity<String> retrieveInvoice(@RequestParam("invoiceID") @NotNull @NotBlank String invoiceID)
    {
        if(validator.validateID(invoiceID)) {
            Stripe.apiKey = stripePublicKey;
            Invoice invoice;
            try {
                invoice = Invoice.retrieve(invoiceID);
            } catch (AuthenticationException e) {
                return new ResponseEntity<>("Problem with user authentication!", HttpStatus.BAD_REQUEST);
            } catch (InvalidRequestException e) {
                return new ResponseEntity<>("Your request data are invalid!", HttpStatus.BAD_REQUEST);
            } catch (ApiConnectionException e) {
                return new ResponseEntity<>("Problem with connection to remote API! Please try later!", HttpStatus.BAD_REQUEST);
            } catch (CardException e) {
                return new ResponseEntity<>("Problem with your card! Please chat with our help center!", HttpStatus.BAD_REQUEST);
            } catch (ApiException e) {
                return new ResponseEntity<>("API doesnt work correctly! Please try later!", HttpStatus.BAD_REQUEST);
            } catch (StripeException e) {
                return new ResponseEntity<>("Global Stripe Api exception!", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(invoice.getDescription(), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Your request data is null or empty", HttpStatus.BAD_REQUEST);
        }
    }


}
