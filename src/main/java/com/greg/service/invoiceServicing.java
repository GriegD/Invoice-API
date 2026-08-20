package com.greg.service;

import com.greg.model.Invoice;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class invoiceServicing {

    List<Invoice> invoices = new CopyOnWriteArrayList<>();

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public Invoice createInvoice(String userID, int amount) {

        // need to work on actual .pdf generation
        // research how to do this, check later
        Invoice invoice =  new Invoice(userID, amount, "http://www.griegory.com/documents/default/sample.pdf");
        invoices.add(invoice);
        return invoice;
    }

}
