package com.greg;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class myServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
    }
}
