package com.greg;

public class invoiceServicing {

    public Invoice createInvoice(String userID, int amount) {

        // need to work on actual .pdf generation
        // research how to do this
        return new Invoice(userID, amount, "http://www.griegory.com/documents/default/sample.pdf");

    }
}
