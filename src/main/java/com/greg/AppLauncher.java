package com.greg;

import com.greg.web.pdfInvoiceServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class AppLauncher {
    public  static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        Context context = tomcat.addContext("", null);
        Wrapper servlet = Tomcat.addServlet(context, "myServlet", new pdfInvoiceServlet());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

        tomcat.start();
    }
}
