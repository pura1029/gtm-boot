package com.vmware.boot.producer.controller;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(value = "/")
@Log4j2
public class AppController {

    @Value("${server.port}")
    private int serverPortHttps;


    @RequestMapping(method = RequestMethod.GET, value = "")
    public void defaultMethod(HttpServletResponse httpServletResponse) throws IOException {
        log.info("Getting default page...");
        String ip = InetAddress.getLocalHost().getHostAddress();
        StringBuilder host = new StringBuilder("https://").append(ip).append(":").append(serverPortHttps).append("/")
                .append("swagger-ui.html");
        httpServletResponse.sendRedirect(host.toString());
    }
}
