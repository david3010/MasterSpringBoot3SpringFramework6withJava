package com.in28minutes.learnspringsecurity.resources;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityPlayResource {
    @GetMapping("/csrf")
    private CsrfToken csrf(HttpServletRequest request) {
        return (CsrfToken)request.getAttribute("_csrf");
    }
}
