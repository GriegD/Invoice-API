package com.greg.web.context;

import com.greg.service.UserService;
import com.greg.service.invoiceService;
import tools.jackson.databind.ObjectMapper;

public class Application {

    public static final UserService userService = new UserService();
    public static final invoiceService invoiceService = new invoiceService(userService);
    public static final ObjectMapper objectMapper = new ObjectMapper();


}
