package com.prueba.softcaribbean.controller;

import com.prueba.softcaribbean.facade.Clientefac;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClientControl {
    private Clientefac cf;
}
