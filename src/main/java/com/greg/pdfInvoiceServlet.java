package com.greg;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;


public class pdfInvoiceServlet extends HttpServlet {

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
            response.getWriter().print("[]");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    if (request.getRequestURI().equalsIgnoreCase("/invoices")) {
        String userID = request.getParameter("userID");
        int amount = Integer.parseInt(request.getParameter("amount"));

        Invoice invoice = new invoiceServicing().createInvoice(userID, amount);
        response.setContentType("application/json; charset=UTF-8");
        String json = new ObjectMapper().writeValueAsString(invoice);
        response.getWriter().print(json);

    } else {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
    }
}
