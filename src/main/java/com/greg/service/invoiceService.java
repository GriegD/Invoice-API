package com.greg.service;

import com.greg.model.Invoice;
import com.greg.model.User;
import com.greg.web.context.Application;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class invoiceService {

    private final UserService userService;

    public invoiceService(UserService userService) {
        this.userService = userService;
    }

    List<Invoice> invoices = new CopyOnWriteArrayList<>();

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public Invoice createInvoice(String userID, int amount) {
        User user = userService.idLookUp(userID);
        if (user == null) {
            throw new IllegalStateException();
        }

        // need to work on actual .pdf generation
        // research how to do this, check later
        Invoice invoice =  new Invoice(userID, amount, "http://www.griegory.com/documents/default/sample.pdf");
        invoices.add(invoice);
        return invoice;
    }

}
