package com.greg.web;

import com.greg.model.Invoice;
import com.greg.service.invoiceServicing;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class pdfInvoiceServlet extends HttpServlet {

    private invoiceServicing invoiceService = new invoiceServicing();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/")) {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print(
                    "<html>\n" +
                            "<head>\n" +
                            "    <title>My Servlet</title>\n" +
                            "    <style>\n" +
                            "        body {\n" +
                            "            background-color: #121212;\n" +
                            "            color: #EAEAEA;\n" +
                            "            font-family: Arial, sans-serif;\n" +
                            "        }\n" +
                            "    </style>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "    <h1>Hello World</h1>\n" +
                            "    <p>Testing Embedded Tomcat by making an HTML page.</p>\n" +
                            "</body>\n" +
                            "</html>"
            );
        } else if (request.getRequestURI().equalsIgnoreCase("/invoices")) {
            response.setContentType("application/json; charset=UTF-8");
            List<Invoice> invoices =  invoiceService.getInvoices();
            response.getWriter().print(objectMapper.writeValueAsString(invoices));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    if (request.getRequestURI().equalsIgnoreCase("/invoices")) {
        String userID = request.getParameter("userID");
        int amount = Integer.parseInt(request.getParameter("amount"));

        Invoice invoice = invoiceService.createInvoice(userID, amount);
        response.setContentType("application/json; charset=UTF-8");
        String json = objectMapper.writeValueAsString(invoice);
        response.getWriter().print(json);

    } else {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
    }
}
