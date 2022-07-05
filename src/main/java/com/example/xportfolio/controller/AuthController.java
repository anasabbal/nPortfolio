package com.example.xportfolio.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.xportfolio.cons.ResourcePath.*;

@RestController
@RequestMapping(V1 + AUTH)
@RequiredArgsConstructor
public class AuthController {
}
