package com;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class hooks {

    webDriverClass driverclass = new webDriverClass();
    String host;

    @Before
    public void open() {

        host = System.getProperty("host");
        if (host.equalsIgnoreCase("UI")) {
            //open browser
            driverclass.openBrowser();
        }
    }


    @After
    public void close() {
        if (host.equalsIgnoreCase("UI")) {
            driverclass.closeBrowser();
        }
    }


}
