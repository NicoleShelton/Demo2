package com.example.demo2.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class RootController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void redirectToApiDocumentation(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
}
